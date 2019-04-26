package com.demo.sharding.serviceImpl.util;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class RandomGenerator {

    private static Random random = new Random();

    public static String getContent(){
        int length = random.nextInt(250)+1;
        String s = RandomStringUtils.randomAlphanumeric(length);
        return s;
    }

    public static float getFloat(){
        return random.nextFloat();
    }

    public static String getName(){
        return RandomStringUtils.randomAlphanumeric(10);
    }

    public static String getChar(){
        return RandomStringUtils.randomAlphabetic(2);
    }

}
