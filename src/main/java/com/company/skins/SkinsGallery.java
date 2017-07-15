package com.company.skins;

import com.company.settings.PropertyType;
import com.company.settings.Settings;

import javax.swing.*;
import java.awt.*;

public final class SkinsGallery {

    private static Image road;

    private static Image player;
    private static Image playerLeft;
    private static Image playerRight;

    private static Image enemy;

    public static Image getRoad() {
        return road;
    }

    public static Image getPlayer() {
        return player;
    }

    public static Image getPlayerLeft() {
        return playerLeft;
    }

    public static Image getPlayerRight() {
        return playerRight;
    }

    public static Image getEnemy() {
        return enemy;
    }

    static {
        initializeSkins();
    }

    private SkinsGallery() {}

    private static void initializeSkins(){

        road = new ImageIcon(Settings.getInstance().getProperty("roadSkin", PropertyType.FullPath)).getImage();

        player = new ImageIcon(Settings.getInstance().getProperty("playerSkin", PropertyType.FullPath)).getImage();
        playerLeft = new ImageIcon(Settings.getInstance().getProperty("playerSkinLeft", PropertyType.FullPath)).getImage();
        playerRight = new ImageIcon(Settings.getInstance().getProperty("playerSkinRight", PropertyType.FullPath)).getImage();

        enemy = new ImageIcon(Settings.getInstance().getProperty("enemySkin", PropertyType.FullPath)).getImage();

    }

}
