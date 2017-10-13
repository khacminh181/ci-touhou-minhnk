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
    BufferedImage straightChar;
    BufferedImage blueEnemy;
    ArrayList<Enemy> blueEnemies = new ArrayList<>();
    int enemycount = 12;

    boolean rightPressed;
    boolean leftPressed;
    boolean downPressed;
    boolean upPressed;

    BufferedImage backBuffer;
    Graphics backGraphics;

    int playerX = 182;
    int playerY = 520;
    int backgroundX = 0;
    int backgroundY = 0;


    public GameCanvas() {
        //1. Create back buffer
        backBuffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        backGraphics = backBuffer.getGraphics();

        // 2. Load Backgroud
        try {
            background = ImageIO.read(new File("assets/images/background/0.png"));
            straightChar = ImageIO.read(new File("assets/images/players/straight/0.png"));
            blueEnemy = ImageIO.read(new File("assets/images/enemies/level0/blue/0.png"));
            System.out.println(background.getHeight());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void enemySpawn(int enemyCount, ArrayList<Enemy> Enemies, BufferedImage enemyType) {
        if (blueEnemies.size() == 0) {
            for (int i = 0; i < enemyCount; i ++) {
                Enemy enemy1 = new Enemy(i*32, 0, enemyType);
                Enemies.add(i,enemy1);
            }
        }
        for (Enemy enemy : Enemies ) {
            backGraphics.drawImage(enemyType, enemy.enemyX, enemy.enemyY, null);
            enemy.enemyRun();
        }

    }



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

        backGraphics.drawImage(straightChar, playerX, playerY, null);
        enemySpawn(enemycount, blueEnemies, blueEnemy);


        //2. Call repaint
        repaint();


    }

    //3. Draw background
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer,0, 0, null);
    }


    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = true;
        }

    }


    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = false;
        }
    }

    public void run() {
       int vx = 0;
       int vy = 0;

       if (rightPressed) {
           if (playerX < 355) {
               vx += 5;
           }
       }

       if (leftPressed) {
           if (playerX > 0) {
               vx -=5;
           }
       }

       if (downPressed) {
           if (playerY < 520) {
               vy += 5;
           }
       }

       if (upPressed) {
           if (playerY > 0) {
               vy -= 5;
           }
       }

        playerX += vx;
        playerY += vy;

    }




}
