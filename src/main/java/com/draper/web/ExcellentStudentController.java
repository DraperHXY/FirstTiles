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
@RequestMapping("/v1/u/excellentStudent")
public class ExcellentStudentController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ExcellentStudentService excellentStudentService;

    @GetMapping("")
    private String studentList(Model model){
        List<ExcellentStudent> excellentStudentList = excellentStudentService.getAllExcellentStudentList();
        model.addAttribute("studentList", excellentStudentList);
        return "excellentStudentListView";
    }

}
