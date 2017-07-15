package com.company;

import com.company.cache.CacheSettings;
import com.company.road.Road;
import javax.swing.*;

public class App {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Speed");
        frame.setSize(CacheSettings.getLengthArenaX(), CacheSettings.getLengthArenaY());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Road());
        frame.setVisible(true);

    }

}

