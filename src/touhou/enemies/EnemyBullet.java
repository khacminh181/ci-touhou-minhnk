package touhou.enemies;

import bases.GameObject;
import bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemyBullet extends GameObject{

    final int SPEED = 10;

    public EnemyBullet() {
        image = Utils.loadImage("assets/images/enemies/bullets/cyan.png");
    }

    public void run() {
        this.position.addUp(0, SPEED);
    }
}
