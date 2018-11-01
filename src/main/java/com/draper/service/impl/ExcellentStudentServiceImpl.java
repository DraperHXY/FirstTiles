package com.draper.service.impl;

import com.draper.dao.ExcellentStudentMapper;
import com.draper.entity.ExcellentStudent;
import com.draper.service.ExcellentStudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ExcellentStudentServiceImpl implements ExcellentStudentService{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ExcellentStudentMapper excellentStudentMapper;

    @Override
    public List<ExcellentStudent> getAllExcellentStudentList() {
        List<ExcellentStudent> excellentStudentList = excellentStudentMapper.selectAllExcellentStudent();
        return excellentStudentList;
    }

    @Override
    public List<ExcellentStudent> getAllExcellentStudentSortList() {
        List<ExcellentStudent> excellentStudentList = excellentStudentMapper.selectAllExcellentStudent();
        Collections.sort(excellentStudentList);
        return excellentStudentList;
    }


}
