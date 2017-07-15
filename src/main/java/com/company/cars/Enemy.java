package com.company.cars;

import com.company.skins.SkinsGallery;

import java.awt.*;

public class Enemy extends ACar{

    public Enemy(int posX, int posY, int acceleration) {
        super(posX, posY, acceleration);
        image = SkinsGallery.getEnemy();
    }

    @Override
    public Image getDefaultImage() {
        return SkinsGallery.getEnemy();
    }

}
