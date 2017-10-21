package touhou.enemies;

import bases.GameObject;
import bases.Utils;
import bases.physics.BoxCollieder;

import java.util.Random;

public class Enemy extends GameObject{

    public BoxCollieder boxCollieder;

    final int SPEED = 2;

    final int LEFT = 0;
    final int RIGHT = 384;
    final int TOP = 25;
    final int BOTTOM = 500;

    long shootingTimer = System.nanoTime();
    long shootingDelay = 400;

    long lastTurn = System.currentTimeMillis();
    int index ;



    public Enemy() {
        image = Utils.loadImage("assets/images/enemies/level0/black/0.png");
        boxCollieder = new BoxCollieder(30, 30);
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
                position.addUp(SPEED, 0);
                break;
            }
            case 1 : {
                position.subtractBy(SPEED, 0);
                break;
            }
            case 2 : {
                position.addUp(0, SPEED);
                break;
            }
            case 3 : {
                position.subtractBy(0, SPEED);
                break;
            }
            case 4 : {
                position.addUp(SPEED, SPEED);
                break;
            }
            case 5 : {
                position.addUp(SPEED, -SPEED);
                break;
            }
            case 6 : {
                position.addUp(-SPEED, SPEED);
                break;
            }
            case 7 : {
                position.subtractBy(SPEED, SPEED);
                break;
            }
        }
        position.x = (int)Utils.clamp(position.x, LEFT, RIGHT);
        position.y = (int)Utils.clamp(position.y, TOP, BOTTOM);


    }

    public void run() {
        randomMove();
        shoot();
        boxCollieder.position.set(this.position);
    }

    public void shoot() {
        long elapsed = (System.nanoTime() - shootingTimer) / 1000000; // tgian chạy = currentTime - shootingTimer
        if (elapsed > shootingDelay) {
            EnemyBullet newBullet = new EnemyBullet();
            newBullet.position.set(this.position);

            GameObject.add(newBullet);
            shootingTimer = System.nanoTime();
        }
    }

    public void getHit() {
        isActive = false;
    }
}
