package com.draper.service;

import com.draper.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void signUp() {
    }

    @Test
    public void hasUser() {
        boolean result = userService.hasUser("ddd");
        System.out.println(result);
    }

    @Test
    public void check() {
    }
}