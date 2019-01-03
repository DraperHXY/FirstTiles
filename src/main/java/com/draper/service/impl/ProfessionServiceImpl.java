package com.draper.service.impl;

import com.danga.MemCached.MemCachedClient;
import com.draper.dao.ProfessionMapper;
import com.draper.entity.Profession;
import com.draper.service.ProfessionService;
import com.draper.util.RedisCacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionServiceImpl implements ProfessionService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProfessionMapper professionMapper;

    @Autowired
    private RedisCacheManager redisCacheManager;

    @Override
    public List<Profession> getFrontProfessionList() {
        long tag1 = System.currentTimeMillis();
        List<Profession> professionList = (List<Profession>) redisCacheManager.get("前端开发方向");

        if (professionList == null) {
            LOGGER.warn("调用 {} 缓存失败", "前端开发方向");
            professionList = professionMapper.selectByDirection("前端开发方向");
            redisCacheManager.set("前端开发方向", professionList);
            LOGGER.warn("更新 {} 缓存", "前端开发方向");
        } else {
            LOGGER.warn("调用 {} 缓存成功", "前端开发方向");
        }
        LOGGER.warn("消耗时间 {}", System.currentTimeMillis() - tag1);

        return professionList;
    }

    @Override
    public List<Profession> getBackProfessionList() {
//        MemCachedClient cached = new MemCachedClient();
//        List<Profession> professionList = (List<Profession>) cached.get("后端开发方向");
//
//        if (professionList == null) {
//            LOGGER.warn("调用 {} 缓存失败", "后端开发方向");
//            professionList = professionMapper.selectByDirection("后端开发方向");
//            cached.add("后端开发方向", professionList);
//            LOGGER.warn("更新 {} 缓存", "后端开发方向");
//        } else {
//            LOGGER.warn("调用 {} 缓存成功", "后端开发方向");
//        }
//
//        return professionList;
        return null;
    }

    @Override
    public List<Profession> getOmProfessionList() {
//        MemCachedClient cached = new MemCachedClient();
//        List<Profession> professionList = (List<Profession>) cached.get("运行维护方向");
//
//        if (professionList == null) {
//            LOGGER.warn("调用 {} 缓存失败", "运行维护方向");
//            professionList = professionMapper.selectByDirection("运行维护方向");
//            cached.add("运行维护方向", professionList);
//            LOGGER.warn("更新 {} 缓存", "运行维护方向");
//        } else {
//            LOGGER.warn("调用 {} 缓存成功", "运行维护方向");
//        }
//
//        return professionList;
        return null;
    }
}
