import bases.GameObject;
import touhou.Enemy;
import touhou.EnemyBullet;
import touhou.Player;
import touhou.PlayerSpell;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GameCanvas extends JPanel{

    BufferedImage background;

    BufferedImage backBuffer;
    Graphics backGraphics;

    Player player = new Player();

    Enemy enemy = new Enemy();
    ArrayList<EnemyBullet> bullets = new ArrayList<>();


    int backgroundX = 0;
    int backgroundY = 0;

    public GameCanvas() {

        //1. Create back buffer
        backBuffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        backGraphics = backBuffer.getGraphics();

        // 2. Load Backgroud
        try {
            background = ImageIO.read(new File("assets/images/background/0.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        GameObject.add(player);
    }
//
//    public void enemySpawn(int enemyCount, ArrayList<touhou.Enemy> Enemies, BufferedImage enemyType) {
//        if (blueEnemies.size() == 0) {
//            for (int i = 0; i < enemyCount; i ++) {
//                touhou.Enemy enemy1 = new touhou.Enemy(i*32, 0, enemyType);
//                Enemies.add(i,enemy1);
//            }
//        }
//        for (touhou.Enemy enemy : Enemies ) {
//            backGraphics.drawImage(enemyType, enemy.enemyX, enemy.enemyY, null);
//            enemy.enemyRun();
//        }
//
//    }



    public void render() {
        //1. Draw everything on back buffer
        backGraphics.drawImage(background, backgroundX,  backgroundY , null);
        backGraphics.drawImage(background, backgroundX,  backgroundY + 3109 , null);

        if (backgroundY > 3109 * -1 ){
            backgroundY -= 10;
        }
        else {
            backgroundY = 0;
        }

        GameObject.renderAll(backGraphics);

//        enemySpawn(enemycount, blueEnemies, blueEnemy);
        //2. Call repaint
        repaint();
    }

    //3. Draw background
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer,0, 0, null);
    }

    public void keyPressed(KeyEvent e) {
        player.keyPressed(e);
    }

    public void keyReleased(KeyEvent e) {
        player.keyReleased(e);
    }

    public void run() {
        GameObject.runAll();
    }

}
