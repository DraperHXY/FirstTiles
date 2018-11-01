package com.draper.service;

import com.draper.entity.Profession;

import java.util.List;

public interface ProfessionService {

    /**
     * @return 前端开发方向职业名单
     */
    List<Profession> getFrontProfessionList();

    /**
     * @return 后端开发方向职业名单
     */
    List<Profession> getBackProfessionList();

    /**
     * OM = Operation and maintenance
     *
     * @return 运行维护方向职业名单
     */
    List<Profession> getOmProfessionList();

}
