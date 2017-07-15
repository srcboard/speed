package com.company.threads;

import com.company.cars.Enemy;
import com.company.logic.Algorithms;

import java.util.ArrayList;
import java.util.Random;

public class WrapperEnemies implements Runnable {

    private ArrayList<Enemy> enemies = new ArrayList<>();

    private WrapperEnemies() {}

    public WrapperEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }

    @Override
    public void run() {

        while (true) {

            if (enemies.size() > 2) {
                continue;
            }

            Random random = new Random();
            try {
                Thread.sleep(random.nextInt(1000));

                Enemy newEnemy = new Enemy(
                        Algorithms.random(0, 380),
                        Algorithms.random(-500, -1000),
                        Algorithms.random(30, 200));

                boolean createEnemy = true;
                for (Enemy e: enemies) {

                    if (newEnemy.getRectangle(0, 0).intersects(e.getRectangle(-200, -200, 200, 200))) {
                        newEnemy = null;
                        createEnemy = false;
                        break;
                    }

                }

                if (createEnemy) {
                    enemies.add(newEnemy);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}
