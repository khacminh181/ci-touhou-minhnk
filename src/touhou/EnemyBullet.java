package touhou;

import bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemyBullet {
    BufferedImage image;
    public int x;
    public int y;
    final int SPEED = 10;

    public EnemyBullet() {
        image = Utils.loadImage("assets/images/enemies/bullets/cyan.png");
    }

    public void render(Graphics graphics) {
        graphics.drawImage(image, x, y, null);
    }

    public void run() {
        y += SPEED;
    }
}
