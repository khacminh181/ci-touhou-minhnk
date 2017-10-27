import bases.GameObject;
import touhou.*;
import touhou.enemies.Enemy;
import touhou.enemies.EnemySpawner;
import touhou.players.Player;
import touhou.players.Sphere;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel{
    BufferedImage backBuffer;
    Graphics backGraphics;

    Player player = new Player();

    Enemy enemy = new Enemy();

    Background background = new Background();

    Sphere sphereLeft = new Sphere();
    Sphere sphereRight = new Sphere();
    public GameCanvas() {

        //1. Create back buffer
        backBuffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        backGraphics = backBuffer.getGraphics();// cho backbufer graphic

        // 2. Load Backgroud

        GameObject.add(background);
        GameObject.add(player);
        GameObject.add(new EnemySpawner());
        GameObject.add(enemy);
        GameObject.add(sphereLeft);
        GameObject.add(sphereRight);

    }

    public void render() {
        //1. Draw everything on back buffer
        GameObject.renderAll(backGraphics);

        //2. Call repaint
        repaint();
    }

    //3. Draw background
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer,0, 0, null);
    }

    public void run() {
        GameObject.runAll();
        sphereLeft.run(player.position.x - 25, player.position.y);
        sphereRight.run(player.position.x + 25, player.position.y);
        if (!player.isActive) {
            sphereRight.isActive = false;
            sphereLeft.isActive = false;
        }
    }

}
