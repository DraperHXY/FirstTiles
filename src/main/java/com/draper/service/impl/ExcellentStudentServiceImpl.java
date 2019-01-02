package com.draper.service.impl;

import com.danga.MemCached.MemCachedClient;
import com.draper.dao.ExcellentStudentMapper;
import com.draper.entity.ExcellentStudent;
import com.draper.service.ExcellentStudentService;
import com.draper.service.Memcached;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ExcellentStudentServiceImpl implements ExcellentStudentService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ExcellentStudentMapper excellentStudentMapper;

    @Override
    public List<ExcellentStudent> getAllExcellentStudentList() {
        MemCachedClient cached = new MemCachedClient();

        List<ExcellentStudent> excellentStudentList = (List<ExcellentStudent>) cached.get("excellentStudentList");

        if (excellentStudentList == null) {
            excellentStudentList = excellentStudentMapper.selectAllExcellentStudent();
            cached.add("excellentStudentList", excellentStudentList);
            LOGGER.warn("调用 {} 缓存失败", "excellentStudentList");
        } else {
            LOGGER.warn("调用 {} 缓存成功", "excellentStudentList");
        }
        LOGGER.warn("excellentStudentList.size = {}", excellentStudentList.size());
        return excellentStudentList;
    }

    @Override
    public List<ExcellentStudent> getAllExcellentStudentSortList() {
        List<ExcellentStudent> excellentStudentList = excellentStudentMapper.selectAllExcellentStudent();
        Collections.sort(excellentStudentList);
        return excellentStudentList;
    }


}
