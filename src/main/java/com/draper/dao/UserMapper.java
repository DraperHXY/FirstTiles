package com.draper.dao;

import com.draper.entity.User;

public interface UserMapper {

    void insertUser(User user);

    User selectUserByAccount(String account);

    long selectUserIdByAccount(String account);

}
