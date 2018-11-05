package com.draper.dao;


import com.draper.BaseTest;
import com.draper.entity.ExcellentStudent;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

public class ExcellentStudentMapperTest extends BaseTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ExcellentStudentMapper excellentStudentMapper;

    @Test
    public void testSelectAllExcellentStudent() {
        List<ExcellentStudent> list = excellentStudentMapper.selectAllExcellentStudent();
        logger.warn("size = {}", list.size());

        Collections.sort(list);


        list.forEach(excellentStudent -> {
            logger.warn("salary = {}", excellentStudent.getSalary());

        });

    }

    @Test
    public void test(){
        System.out.println(System.currentTimeMillis());
    }

}
