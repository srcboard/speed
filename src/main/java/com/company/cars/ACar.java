package com.company.cars;

import com.company.skins.SkinsGallery;

import java.awt.*;
import java.awt.event.KeyEvent;

public abstract class ACar implements ICar{

    protected Image image;

    private int speed;
    private int posX;
    private int posY;

    private int acceleration;

    private int positionX = 0;

    public ACar(int posX, int posY, int acceleration) {
        this.posX = posX;
        this.posY = posY;
        this.acceleration = acceleration;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public Image getImage() {
        return image;
    }

    @Override
    public int getMaxSpeed() {
        return 50;
    }

    @Override
    public void move() {

        speed += acceleration;
        posX += positionX;

        restoreSpeed();

    }

    public void keyPressed(KeyEvent event) {

        int key = event.getKeyCode();
        switch (key) {
            case KeyEvent.VK_UP:
                acceleration = 1;
                break;
            case KeyEvent.VK_DOWN:
                acceleration = -1;
                break;
            case KeyEvent.VK_LEFT:
                positionX = -10;
                image = SkinsGallery.getPlayerLeft();
                break;
            case KeyEvent.VK_RIGHT:
                positionX = 10;
                image = SkinsGallery.getPlayerRight();
                break;
        }

    }

    public void keyReleased(KeyEvent event) {

        image = getDefaultImage();

        int key = event.getKeyCode();
        switch (key) {
            case KeyEvent.VK_UP:
                acceleration = 0;
                break;
            case KeyEvent.VK_DOWN:
                acceleration = 0;
                break;
            case KeyEvent.VK_LEFT:
                positionX = 0;
                break;
            case KeyEvent.VK_RIGHT:
                positionX = 0;
                break;
        }

    }

    private void restoreSpeed(){

        // min speed
        speed = speed > 0 ? speed : 0;

        // max speed
        speed = speed < getMaxSpeed() ? speed : getMaxSpeed();

    }

    public Rectangle getRectangle(int addX, int addY) {
        return new Rectangle(posX + addX, posY + addY, 100, 200);
    }

    public Rectangle getRectangle(int addX, int addY, int addWidth, int addHeight) {
        return new Rectangle(posX + addX, posY + addY, 100 + addWidth, 200 + addHeight);
    }

}
