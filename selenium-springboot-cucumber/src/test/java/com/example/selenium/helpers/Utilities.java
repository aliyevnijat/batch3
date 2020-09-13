package com.example.selenium.helpers;

import java.util.Random;

public class Utilities {

    public static int generateRandomNum(int upTo){
        Random random = new Random();
        return random.nextInt(upTo-5)+4;
    }
}
