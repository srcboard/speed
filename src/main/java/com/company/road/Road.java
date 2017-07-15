package com.company.road;

import com.company.cars.Enemy;
import com.company.cars.Player;
import com.company.skins.SkinsGallery;
import com.company.threads.WrapperEnemies;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class Road extends JPanel implements ActionListener {

    private Image image = SkinsGallery.getRoad();

    private int roadX;

    private int collisions = 3;

    private Timer timer = new Timer(50, this);
    private Player player = new Player(60, 500, 0);
    private ArrayList<Enemy> enemies = new ArrayList<>();

    public Road(){

        timer.start();
        addKeyListener(new myKeyAdapter());
        setFocusable(true);

        // Launch enemies factory
        WrapperEnemies wrapperEnemies = new WrapperEnemies(enemies);
        Thread threadEnemies = new Thread(wrapperEnemies);
        threadEnemies.start();

    }

    private class myKeyAdapter extends KeyAdapter {



        public void keyPressed(KeyEvent event) {
            player.keyPressed(event);
        }

        public void keyReleased(KeyEvent event) {
            player.keyReleased(event);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        player.move();
        repaint();

        Iterator<Enemy> i = enemies.iterator();
        while (i.hasNext()) {
            Enemy enemy = i.next();
            if (!player.getRectangle(0, 0).intersects(enemy.getRectangle(0, roadX))) {
                continue;
            }

            collisions -= 1;
            if (collisions == 0) {
                JOptionPane.showMessageDialog(null, "You lose!");
                System.exit(1);
            }

        }

    }

    @Override
    public void paint(Graphics g) {

        roadX += player.getSpeed();

        g.drawImage(image, 0, roadX, null);
        g.drawImage(image, 0, roadX - 1000, null);
        g.drawImage(image, 0, roadX - 2000, null);

        g.drawImage(player.getImage(), player.getPosX(), player.getPosY(), null);

        g.setColor(Color.WHITE);
        g.drawString("Collisions: " + collisions, 10, 810);
        g.drawString("Enemies: " + enemies.size(), 10, 830);
        g.drawString("Speed: " + player.getSpeed() + " km/h", 10, 850);

        Iterator<Enemy> iterator = enemies.iterator();
        while (iterator.hasNext()) {

            Enemy enemy = iterator.next();
            if (enemy.getPosY() + roadX < 1000 && enemy.getPosY() + roadX > -1000
                    && !player.getRectangle(0, 0).intersects(enemy.getRectangle(0, roadX))) {
                enemy.move();
                g.drawImage(enemy.getImage(), enemy.getPosX(), enemy.getPosY() + roadX, null);
            } else {
                iterator.remove();
            }

        }

        normalizeValues();

    }

    private void normalizeValues() {

        // max road
        roadX = roadX < 2000 ? roadX : 0;

    }

}
