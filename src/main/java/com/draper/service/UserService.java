package com.draper.service;

import com.draper.entity.User;

public interface UserService {

    long signUpByPhone(User user);

    long signUpByEmail(User user);

    boolean hasUser(String account);

    boolean check(User expectUser);

}
