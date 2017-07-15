package com.company.cache;

import com.company.settings.Settings;

public class CacheSettings {

    private static int lengthArenaX;
    private static int lengthArenaY;

    static {
        lengthArenaX = Integer.valueOf(Settings.getInstance().getProperty("lengthArenaX"));
        lengthArenaY = Integer.valueOf(Settings.getInstance().getProperty("lengthArenaY"));
    }

    private CacheSettings() {}

    public static int getLengthArenaX() {
        return lengthArenaX;
    }

    public static int getLengthArenaY() {
        return lengthArenaY;
    }

}
