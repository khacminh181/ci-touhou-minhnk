package touhou.enemies;

import bases.GameObject;
import bases.Utils;
import bases.physics.BoxCollieder;
import bases.physics.PhysicsBody;

import java.util.Random;

public class Enemy extends GameObject implements PhysicsBody{

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

    PlayerDamage playerDamage;

    //Enemy shoot
    boolean bulletDisable = false;
    final int COOL_DOWN_TIME = 50;
    int coolDownCount;

    public Enemy() {
        image = Utils.loadImage("assets/images/enemies/level0/black/0.png");
        boxCollieder = new BoxCollieder(30, 30);
        this.playerDamage = new PlayerDamage();
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
        this.playerDamage.run(this);
    }

    public void shoot() {
//        long elapsed = (System.nanoTime() - shootingTimer) / 1000000; // tgian chạy = currentTime - shootingTimer
//        if (elapsed > shootingDelay) {
//            EnemyBullet newBullet = new EnemyBullet();
//            newBullet.position.set(this.position);
//
//            GameObject.add(newBullet);
//            shootingTimer = System.nanoTime();
//        }
        if (bulletDisable) {
            coolDownCount++;
            if (coolDownCount >= COOL_DOWN_TIME) {
                bulletDisable = false;
                coolDownCount = 0;
            }
            return;
        }

        EnemyBullet newEnemyBullet = GameObject.recycle(EnemyBullet.class);
        newEnemyBullet.position.set(this.position);

        bulletDisable = true;

    }

    public void getHit() {
        isActive = false;
    }


    @Override
    public BoxCollieder getBoxCollider() {
        return boxCollieder;
    }
}
