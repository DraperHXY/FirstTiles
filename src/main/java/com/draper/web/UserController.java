package com.draper.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;

@Controller
@RequestMapping("/v1/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("")
    public String signUpUser(@RequestParam("account") String account, @RequestParam("password") String password) {
        logger.warn("account = [{}]", account);
        logger.warn("password = [{}]", password);
        return "redirect:/v1/index";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "";
    }


}
