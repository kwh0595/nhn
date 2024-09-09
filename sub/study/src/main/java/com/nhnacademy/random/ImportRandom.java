package com.nhnacademy.random;

import org.apache.commons.math3.random.RandomDataGenerator;

public class ImportRandom {
    public static void importRandom(){
        RandomDataGenerator random = new RandomDataGenerator();
        System.out.println(random.nextInt(1,100));
    }
}
