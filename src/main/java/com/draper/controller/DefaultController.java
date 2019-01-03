package com.draper.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DefaultController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @GetMapping("")
    private String indexPage() {
        return "indexView";
//        return "loginView";
//        return "redirect:/v1/index";
//        return "test";
    }

    @GetMapping("/test")
    private String testOne() {
        return "testView";
    }

    @DeleteMapping("/test")
    private String testTwo(@RequestParam("account") String account) {
        LOGGER.warn(account);
        LOGGER.warn("可以处理删除方法");
        return "redirect:/v1/index";
//        return "mainLayout";
    }

}
