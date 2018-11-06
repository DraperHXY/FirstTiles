package com.draper.service;

import com.draper.entity.User;

import javax.servlet.http.Cookie;

public interface CookieService {

    Cookie[] addUser(User user);

    boolean verifyUser(Cookie... cookie);

    Cookie remove(String cookieName);

}
