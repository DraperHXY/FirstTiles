package com.draper.dao;

import com.draper.BaseTest;
import com.draper.entity.Profession;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProfessionMapperTest extends BaseTest {

    @Autowired
    public ProfessionMapper professionMapper;

    @Test
    public void testSelectByDirection() {
        List<Profession> professionList = professionMapper.selectByDirection("前端开发方向");
        Assert.assertEquals(3, professionList.size());
    }




}
