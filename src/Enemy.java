import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy {
    int enemyX;
    int enemyY;
    BufferedImage enemy;

    public Enemy(int enemyX, int enemyY, BufferedImage enemy) {
        this.enemyX = enemyX;
        this.enemyY = enemyY;
        this.enemy = enemy;
    }

    public void enemyRun() {
        //this.enemyX++;
        this.enemyY ++;
    }

}
