package com.draper.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {

    @GetMapping("")
    private String indexPage() {
        return "indexView";
//        return "loginView";
//        return "redirect:/v1/index";
//        return "test";
    }

    @GetMapping("test")
    private String testPage() {
        return "test";
    }

}
