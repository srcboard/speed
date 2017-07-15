package com.company.logic;

public final class Algorithms {

    private Algorithms() {}

    public static int random(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

}


