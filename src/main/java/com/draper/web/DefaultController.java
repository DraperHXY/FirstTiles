package com.draper.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    private String indexPage() {
        return "redirect:/v1/index";
//        return "test";
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    private String testPage() {
        return "test";
    }

}
