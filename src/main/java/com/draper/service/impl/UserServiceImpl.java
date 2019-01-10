package com.draper.service.impl;

import com.draper.dao.UserMapper;
import com.draper.entity.User;
import com.draper.service.UserService;
import org.apache.ibatis.binding.BindingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public long signUpByPhone(User user) {
        userMapper.insertPhoneUser(user);
        return userMapper.selectUserIdByPhone(user.getPhone());
    }

    @Override
    public long signUpByEmail(User user) {
        userMapper.insertEmailUser(user);
        return userMapper.selectUserIdByEmail(user.getEmail());
    }

    @Override
    public boolean hasUser(String account) {
        try {
            userMapper.selectUserIdByPhone(account);
            return true;
        } catch (BindingException e){
            return false;
        }
    }

    @Override
    public boolean check(User expectUser) {
        User realUser = userMapper.selectUserByPhone(expectUser.getPhone());
        if (realUser.getPassword().equals(expectUser.getPassword())) {
            return true;
        }
        return false;
    }

}
