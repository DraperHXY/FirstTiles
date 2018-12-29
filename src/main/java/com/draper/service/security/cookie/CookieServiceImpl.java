package com.draper.service.security.cookie;

import com.draper.entity.User;
import com.draper.service.CookieService;
import com.draper.service.UserService;
import com.draper.service.security.DES.DESFactory;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import java.util.Date;

@Service
public class CookieServiceImpl implements CookieService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Override
    public Cookie[] addUser(User user) {
        Cookie[] cookies = new Cookie[3];
        LOGGER.warn("添加 cookie");
        LOGGER.warn("account = {}", user.getAccount());
        LOGGER.warn("password = {}", user.getPassword());

        Cookie accountCookie = new Cookie("account", user.getAccount());
        Cookie passwordCookie = new Cookie("password", user.getPassword());

        String authorizationMessage = null;
        authorizationMessage = user.getId() + " " + System.currentTimeMillis();
        byte[] encryptAuthorizationMessage = new DESFactory.Builder().encrypt(authorizationMessage.getBytes());
        Cookie authorizationCookie = null;
        authorizationCookie = new Cookie("authorization", Base64.encodeBase64String(encryptAuthorizationMessage));

        cookies[0] = accountCookie;
        cookies[1] = passwordCookie;
        cookies[2] = authorizationCookie;

        LOGGER.warn("");
        return cookies;
    }

    @Override
    public boolean verifyUser(Cookie... cookies) {
        LOGGER.warn("验证 Cookie");
        String account = null;
        String password = null;
        String authorization = null;

        for (Cookie cookie : cookies) {
            if ("account".equals(cookie.getName())) {
                account = cookie.getValue();
            } else if ("password".equals(cookie.getName())) {
                password = cookie.getValue();
            } else if ("authorization".equals(cookie.getName())) {
                authorization = cookie.getValue();
            }
        }

        LOGGER.warn("account = " + account);
        LOGGER.warn("password = " + password);
        if (account == null || password == null || authorization == null) {
            return false;
        } else {

            LOGGER.warn("userService = " + userService);
            User user = new User();
            user.setAccount(account);
            user.setPassword(password);

            byte[] encryptAuthorization = Base64.decodeBase64(authorization);
            encryptAuthorization = new DESFactory.Builder().decrypt(encryptAuthorization);
            String message = new String(encryptAuthorization);
            String[] str = message.split(" ");
            LOGGER.warn("user.id = {}", str[0]);
            LOGGER.warn("user.loginTime = {}", new Date(Long.valueOf(str[1])));
            return userService.check(user);
        }
    }

    @Override
    public Cookie remove(String cookieName) {
        Cookie cookie = new Cookie(cookieName, null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        return cookie;
    }


}
