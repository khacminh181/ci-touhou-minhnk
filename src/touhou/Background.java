package touhou;

import bases.GameObject;
import bases.Utils;

import java.awt.*;

public class Background extends GameObject {

    public Background() {
        position.set(0, 0);
        image = Utils.loadImage("assets/images/background/0.png");
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(image, (int)position.x, (int)position.y, null);
        g.drawImage(image, (int)position.x, (int)position.y - 3109, null);
    }

    @Override
    public void run() {
        if (position.y < 3109){
            position.y += 1;
        }
        else {
            position.y = 0;
        }
    }
}
