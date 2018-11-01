package com.draper.web;

import com.draper.entity.ExcellentStudent;
import com.draper.service.ExcellentStudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/v1")
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ExcellentStudentService excellentStudentService;

    @GetMapping("/index")
    public String indexPage(Model model) {
        List<ExcellentStudent> excellentStudentList =
                excellentStudentService.getAllExcellentStudentSortList();
        model.addAttribute("excellentStudentList", excellentStudentList);
        return "indexView";
    }

}
