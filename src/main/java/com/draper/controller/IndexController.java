package com.draper.controller;

import com.draper.entity.ExcellentStudent;
import com.draper.service.ExcellentStudentService;
import com.draper.util.TestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;

@Controller
@RequestMapping("/v1")
public class IndexController {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ExcellentStudentService excellentStudentService;

    @Autowired
    private TestUtil testUtil;

    @Autowired
    private JedisPoolConfig poolConfig;

    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;



    @GetMapping("/index")
    public String indexPage(Model model) {

        if (poolConfig == null) {
            throw new NullPointerException("FFUCK");
        } else {
            LOGGER.warn("NOT NPE");
        }

        if (jedisConnectionFactory == null) {
            throw new NullPointerException("FFFUCK");
        } else {
            LOGGER.warn("NOT NPE");
        }

        if (redisTemplate == null) {
            throw new NullPointerException("FFFFUCK");
        } else {
            LOGGER.warn("NOT NPE");
        }




        List<ExcellentStudent> excellentStudentList =
                excellentStudentService.getAllExcellentStudentSortList();
        model.addAttribute("excellentStudentList", excellentStudentList);
        return "indexView";
    }

    @GetMapping("/u/studentList")
    public String studentPage(){
        return "excellentStudentListView";
    }

}
