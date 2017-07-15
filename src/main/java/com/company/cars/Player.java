package com.company.cars;

import com.company.skins.SkinsGallery;

import java.awt.*;

public class Player extends ACar{

    public Player(int posX, int posY, int acceleration) {
        super(posX, posY, acceleration);
        image = SkinsGallery.getPlayer();
    }

    @Override
    public Image getDefaultImage() {
        return SkinsGallery.getPlayer();
    }

}
