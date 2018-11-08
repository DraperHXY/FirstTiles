package com.draper.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    private String testTwo() {
        LOGGER.warn("可以处理删除方法");
        return "redirect:/v1/index";
//        return "mainLayout";
    }

}
