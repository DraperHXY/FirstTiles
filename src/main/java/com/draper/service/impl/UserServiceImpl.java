package com.draper.service.impl;

import com.draper.dao.UserMapper;
import com.draper.entity.User;
import com.draper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public long signUp(User user) {
        userMapper.insertUser(user);
        return userMapper.selectUserIdByAccount(user.getAccount());
    }

}
