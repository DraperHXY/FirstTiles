package com.draper.controller;

import com.draper.entity.User;
import com.draper.service.UserService;
import com.draper.service.security.MD5.MD5Util;
import com.draper.service.CookieService;
import com.draper.util.RandomVerifyCode;
import com.draper.util.RedisClusterCache;
import com.draper.util.SMSManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Set;

@Controller
@RequestMapping("/v1/user")
public class UserController {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CookieService cookieService;

    @Autowired
    private UserService userService;

    @Autowired
    private RedisClusterCache redisClusterCache;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/loginUp")
    public String loginUpUser(@RequestParam HashMap<String, String> requestParam) {

        String name = requestParam.get("name");
        String firstPassword = requestParam.get("firstPassword");
        String secondPassword = requestParam.get("secondPassword");
        String phone = requestParam.get("phoneNumber");
        String verifyCode = requestParam.get("verifyCode");

        LOGGER.warn("name = {}", name);
        LOGGER.warn("firstPassword = {}", firstPassword);
        LOGGER.warn("secondPassword = {}", secondPassword);
        LOGGER.warn("phone = {}", phone);

        String smsCode = String.valueOf(redisClusterCache.get("phone" + phone));

        if (!firstPassword.equals(secondPassword)) {
            LOGGER.warn("phone = {}, 两次密码不相符", phone);
            return "";
        }

        if (!smsCode.equals(verifyCode)) {
            LOGGER.warn("phone = {}, 验证码错误", phone);
            return "";
        }

        User user = new User();
        user.setName(name);
        user.setPassword(MD5Util.md5Password(firstPassword));
        user.setPhone(phone);

        LOGGER.warn("phone = {}, 开始注册", phone);
        userService.signUp(user);

        return "loginView";
    }

    @GetMapping("/loginUp")
    public String loginUpGet() {
        return "loginUpView";
    }

    @GetMapping("/loginIn")
    public String loginPage() {
        return "loginView";
    }

    @GetMapping("/loginOut")
    public String loginOut(HttpServletResponse response) {
        Cookie cookie = cookieService.remove("account");
        response.addCookie(cookie);
        return "indexView";
    }

    @PostMapping("/loginIn")
    public String login(@RequestParam("phone") String phone, @RequestParam("password") String password, HttpServletResponse response) {
        User user = new User();
        user.setPhone(phone);
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

    @Autowired
    private SMSManager smsManager;

    @PostMapping("/sendPhoneCode")
    public void sendLoginUpCode(@RequestParam("phone") String phone) {

        int code = RandomVerifyCode.getRandomCode();

        LOGGER.warn("手机号 = {}，验证码 = {}", phone, code);

        redisClusterCache.put("phone" + phone, code);

        HashMap<String, Object> result = smsManager.sendTemplateSMS(phone, "1", new String[]{String.valueOf(code), "15"});

        if ("000000".equals(result.get("statusCode"))) {
            LOGGER.warn("用户登录成功");
            //正常返回输出data包体信息（map）
            HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
            Set<String> keySet = data.keySet();
            for (String key : keySet) {
                Object object = data.get(key);
                System.out.println(key + " = " + object);
            }
        } else {
            //异常返回输出错误码和错误信息
            LOGGER.error("错误手机号={},错误码={},错误信息={}", phone, result.get("statusCode"), result.get("statusMsg"));
        }

    }


}
