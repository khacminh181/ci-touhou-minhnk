package touhou;

import bases.GameObject;
import bases.Utils;

import java.util.ArrayList;
import java.util.Random;

public class Enemy extends GameObject{
    final int SPEED = 2;

    final int LEFT = 0;
    final int RIGHT = 350;
    final int TOP = 0;
    final int BOTTOM = 500;

    long shootingTimer = System.nanoTime();
    long shootingDelay = 400;

    long lastTurn = System.currentTimeMillis();
    int index ;



    public Enemy() {
        x = 134;
        y = 143;
        image = Utils.loadImage("assets/images/enemies/level0/black/0.png");
    }

    public void randomMove() {
        if (System.currentTimeMillis() - lastTurn >= 1000) {
            Random random = new Random();
            this.index = random.nextInt(8);
            System.out.println(index);

            lastTurn = System.currentTimeMillis();
        }
        switch (index) {
            case 0 : {
                x += SPEED;
                break;
            }
            case 1 : {
                x -= SPEED;
                break;
            }
            case 2 : {
                y += SPEED;
                break;
            }
            case 3 : {
                y -= SPEED;
                break;
            }
            case 4 : {
                x += SPEED;
                y += SPEED;
                break;
            }
            case 5 : {
                x += SPEED;
                y -= SPEED;
                break;
            }
            case 6 : {
                x -= SPEED;
                y += SPEED;
                break;
            }
            case 7 : {
                x -= SPEED;
                y -= SPEED;
                break;
            }
        }
        x = (int)Utils.clamp(x, LEFT, RIGHT);
        y = (int)Utils.clamp(y, TOP, BOTTOM);


    }

    public void run() {
        randomMove();
        shoot();
    }

    public void shoot() {
        long elapsed = (System.nanoTime() - shootingTimer) / 1000000; // tgian chạy = currentTime - shootingTimer
        if (elapsed > shootingDelay) {
            EnemyBullet newBullet = new EnemyBullet();
            newBullet.x = x;
            newBullet.y = y;

            GameObject.add(newBullet);
            shootingTimer = System.nanoTime();
        }
    }
}
