package touhou;

import bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy {
    BufferedImage image;

    int x = 0;
    int y = 0;
    final int SPEED = 1;

    long shootingTimer = System.nanoTime();
    long shootingDelay = 400;


    public Enemy() {
        image = Utils.loadImage("assets/images/enemies/level0/black/0.png");
    }

    public void render(Graphics graphics) {
        graphics.drawImage(image, x, y, null);
    }

    public void run() {
        y += SPEED;
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
