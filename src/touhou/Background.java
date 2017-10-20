package touhou;

import bases.GameObject;
import bases.Utils;

import java.awt.*;

public class Background extends GameObject {

    public Background() {
        x = 0;
        y = 0;
        image = Utils.loadImage("assets/images/background/0.png");
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(image, (int)x, (int)y, null);
        g.drawImage(image, (int)x, (int)y - 3109, null);
    }

    @Override
    public void run() {
        if (y < 3109){
            y += 10;
        }
        else {
            y = 0;
        }
    }
}
