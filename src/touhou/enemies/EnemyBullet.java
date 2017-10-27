package touhou.enemies;

import bases.GameObject;
import bases.Utils;
import bases.physics.BoxCollieder;
import touhou.players.Player;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemyBullet extends GameObject{

    final int SPEED = 10;
    BoxCollieder boxCollieder;


    public EnemyBullet() {
        image = Utils.loadImage("assets/images/enemies/bullets/cyan.png");
        boxCollieder = new BoxCollieder(15, 15);
    }

    public void run() {
        this.position.addUp(0, SPEED);
        boxCollieder.position.set(this.position);

        Player player = GameObject.collideWith(this.boxCollieder, Player.class);
        if (player != null) {
            System.out.println("Player get hit");
            this.isActive = false;
            player.hP -= 1;
            if (player.hP <= 0) {
                player.getHit();
            }
        }
    }
}
