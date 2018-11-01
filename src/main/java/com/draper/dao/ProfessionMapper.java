package com.draper.dao;

import com.draper.entity.Profession;

import java.util.List;

public interface ProfessionMapper {

    List<Profession> selectByDirection(String direction);

}
