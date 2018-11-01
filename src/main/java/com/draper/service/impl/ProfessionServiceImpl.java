package com.draper.service.impl;

import com.draper.dao.ProfessionMapper;
import com.draper.entity.Profession;
import com.draper.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionServiceImpl implements ProfessionService {

    @Autowired
    private ProfessionMapper professionMapper;

    @Override
    public List<Profession> getFrontProfessionList() {
        return professionMapper.selectByDirection("前端开发方向");
    }

    @Override
    public List<Profession> getBackProfessionList() {
        return professionMapper.selectByDirection("后端开发方向");
    }

    @Override
    public List<Profession> getOmProfessionList() {
        return professionMapper.selectByDirection("运行维护方向");
    }
}
