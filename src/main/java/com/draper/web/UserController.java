package com.draper.web;

import com.draper.entity.User;
import com.draper.service.UserService;
import com.draper.service.security.MD5.MD5Util;
import com.draper.service.CookieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private CookieService cookieService;

    @Autowired
    private UserService userService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/loginUp")
    public String loginUpUser(@RequestParam("account") String account, @RequestParam("password") String password) {
        User user = new User();
        user.setAccount(account);
        user.setPassword(MD5Util.md5Password(password));

        if (userService.hasUser(account)){
            return "loginView";
        } else {
            userService.signUp(user);
            return "loginView";
        }
    }

    @GetMapping("/loginIn")
    public String loginPage() {
        return "loginView";
    }

    @GetMapping("/loginOut")
    public String loginOut(HttpServletResponse response){
        Cookie cookie = cookieService.remove("account");
        response.addCookie(cookie);
        return "indexView";
    }

    @PostMapping("/loginIn")
    public String login(@RequestParam("account") String account, @RequestParam("password") String password, HttpServletResponse response) {
        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        if (userService.check(user)) {
            Cookie[] cookies = cookieService.addUser(user);
            for (Cookie cookie : cookies) {
                logger.warn("添加 cookie");
                logger.warn("cookie name = {}", cookie.getName());
                logger.warn("cookie value = {}", cookie.getValue());
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
        return "indexView";
    }


}
