package touhou;

import bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class Enemy {
    BufferedImage image;

    int x = 134;
    int y = 143;
    final int SPEED = 2;

    long shootingTimer = System.nanoTime();
    long shootingDelay = 400;

    long lastTurn = System.currentTimeMillis();
    int index ;



    public Enemy() {
        image = Utils.loadImage("assets/images/enemies/level0/black/0.png");
    }

    public void render(Graphics graphics) {
        graphics.drawImage(image, x, y, null);
    }

    public void randomRun() {
        if (System.currentTimeMillis() - lastTurn >= 1000) {
            Random random = new Random();
            this.index = random.nextInt(8);
            System.out.println(index);

            lastTurn = System.currentTimeMillis();
        }


    }

    public void run() {
        randomRun();
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
    }

    public void shoot(ArrayList<EnemyBullet> bullets) {
        long elapsed = (System.nanoTime() - shootingTimer) / 1000000; // tgian chạy = currentTime - shootingTimer
        if (elapsed > shootingDelay) {
            EnemyBullet newBullet = new EnemyBullet();
            newBullet.x = x;
            newBullet.y = y;

            bullets.add(newBullet);
            shootingTimer = System.nanoTime();
        }
    }
}
