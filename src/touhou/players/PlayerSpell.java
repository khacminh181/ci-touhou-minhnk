package touhou.players;

import bases.GameObject;
import bases.Utils;
import bases.physics.BoxCollieder;
import touhou.enemies.Enemy;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class PlayerSpell extends GameObject {

    final int SPEED = 20;
    BoxCollieder boxCollieder;

    public PlayerSpell() {
        image = Utils.loadImage("assets/images/player-bullets/a/0.png");
        boxCollieder = new BoxCollieder(20, 20);
    }

    public void run() {
        this.position.subtractBy(0, SPEED);
        boxCollieder.position.set(this.position);

        Enemy enemy = GameObject.collideWith(this.boxCollieder);
        if (enemy != null) {
            System.out.println("Hit");
            enemy.getHit();
            this.isActive = false;

        }
    }
}
