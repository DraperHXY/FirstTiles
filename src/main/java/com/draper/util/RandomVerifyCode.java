package com.draper.util;

import java.util.Random;

public class RandomVerifyCode {

    private static Random random = new Random();

    private final static int MAX = 9999;

    private final static int MIN = 1000;

    public static int getRandomCode() {
        return random.nextInt(MAX) % (MAX - MIN + 1) + MIN;
    }

}
