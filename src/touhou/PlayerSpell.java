package touhou;

import bases.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class PlayerSpell {
    BufferedImage image;
    public int x;
    public int y;
    final int SPEED = 20;

    public PlayerSpell() {
        image = Utils.loadImage("assets/images/player-bullets/a/0.png");
    }

    public void render(Graphics graphics) {
        graphics.drawImage(image, x, y, null);
    }

    public void run() {
        y -= SPEED;

    }
}
