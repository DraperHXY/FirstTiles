package com.draper.controller;

import com.draper.entity.Profession;
import com.draper.service.ProfessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/v1")
public class ProfessionController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProfessionService professionService;

    @GetMapping("/profession")
    public String indexPage(ModelMap mmp) {
        List<Profession> frontProfessionList = professionService.getFrontProfessionList();
        List<Profession> backProfessionList = professionService.getBackProfessionList();
        List<Profession> omProfessionList = professionService.getOmProfessionList();

        mmp.addAttribute("frontProfessionList", frontProfessionList);
        mmp.addAttribute("backProfessionList", backProfessionList);
        mmp.addAttribute("omProfessionList", omProfessionList);

        return "professionView";
    }

}
