package touhou.players;

import bases.GameObject;
import bases.Utils;
import bases.physics.BoxCollieder;
import touhou.enemies.Enemy;

import java.awt.image.BufferedImage;

public class SphereBullet extends GameObject{

    final int SPEED = 20;
    BoxCollieder boxCollieder;

    public SphereBullet() {
        image = Utils.loadImage("assets/images/sphere-bullets/0.png");
        boxCollieder = new BoxCollieder(20, 20);
    }

    public void run() {
        this.position.subtractBy(0, SPEED);
        boxCollieder.position.set(this.position);

        Enemy enemy = GameObject.collideWith(this.boxCollieder, Enemy.class);
        if (enemy != null) {
            System.out.println("Sphere Hit Enemy");
            enemy.getHit();
            this.isActive = false;

        }

        deactiveIfNeded();
    }

    private void deactiveIfNeded() {
        if (position.y < 0) {
            this.isActive = false;
        }
    }


}
