package com.draper.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1")
public class ExcellentStudentController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

}
