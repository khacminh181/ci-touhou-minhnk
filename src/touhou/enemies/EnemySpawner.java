package touhou.enemies;

import bases.FrameCounter;
import bases.GameObject;
import touhou.players.SphereBullet;

import java.util.Random;

public class EnemySpawner extends GameObject{

    FrameCounter frameCounter = new FrameCounter(120);
    Random random = new Random();


    @Override
    public void run() {
        if (frameCounter.run()) {
            frameCounter.reset();
            spawn();
        }
    }

    private void spawn() {
//        Enemy enemy = new Enemy();
//        position.set(10, random.nextInt(360));
//        GameObject.add(enemy);

        Enemy newEnemy = GameObject.recycle(Enemy.class);
        newEnemy.position.set(random.nextInt(360), 0);
    }
}
