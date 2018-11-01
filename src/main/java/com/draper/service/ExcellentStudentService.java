package com.draper.service;

import com.draper.entity.ExcellentStudent;

import java.util.List;

public interface ExcellentStudentService {

    /**
     * @return 返回优秀学员名单
     */
    List<ExcellentStudent> getAllExcellentStudentList();

    /**
     * @return 返回经过排序后的优秀学员名单
     */
    List<ExcellentStudent> getAllExcellentStudentSortList();

}
