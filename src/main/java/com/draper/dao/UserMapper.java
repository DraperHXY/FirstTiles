package com.draper.dao;

import com.draper.entity.User;

public interface UserMapper {

    void insertPhoneUser(User user);

    User selectUserByPhone(String phone);

    long selectUserIdByPhone(String phone);

}
