package touhou;

import bases.GameObject;
import bases.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject {

    boolean rightPressed;
    boolean leftPressed;
    boolean downPressed;
    boolean upPressed;

    boolean xPressed;

    final int SPEED = 5; // final = const

    final int LEFT = 0;
    final int RIGHT = 360;
    final int TOP = 0;
    final int BOTTOM = 520;

//    long shootingTimer = System.nanoTime();
//    long shootingDelay = 100;

    boolean spellDisabled = false;
    final int COOL_DOWN_TIME = 10;

    public Player() {
        x = 182;
        y = 520;
        image = Utils.loadImage("assets/images/players/straight/0.png");
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
        if (e.getKeyCode() == KeyEvent.VK_X) {
            xPressed = true;
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
        if (e.getKeyCode() == KeyEvent.VK_X) {
            xPressed = false;
        }
    }

    public void run() {
        move();
        shoot();
    }

    private void move() {
        int vx = 0;
        int vy = 0;

        if (rightPressed) {
            vx += SPEED;
        }

        if (leftPressed) {
            vx -=SPEED;
        }

        if (downPressed) {
            vy += SPEED;
        }

        if (upPressed) {
            vy -= SPEED;
        }

        x += vx;
        y += vy;

        x = (int)Utils.clamp(x, LEFT, RIGHT);
        y = (int)Utils.clamp(y, TOP, BOTTOM);
    }

    int coolDownCount;

    public void shoot() {
        if (spellDisabled) {
            coolDownCount++;
            if (coolDownCount >= COOL_DOWN_TIME) {
                spellDisabled = false;
                coolDownCount = 0;
            }
            return;
        }

        if (xPressed) {
            PlayerSpell newSpell = new PlayerSpell();
            newSpell.x = x;
            newSpell.y = y;

            GameObject.add(newSpell);

            spellDisabled = true;
        }
//        if (xPressed) {
//            long elapsed = (System.nanoTime() - shootingTimer) / 1000000; // tgian chạy = currentTime - shootingTimer
//            if (elapsed > shootingDelay) {
//                PlayerSpell newSpell = new PlayerSpell();
//                newSpell.x = x;
//                newSpell.y = y;
//
//                spells.add(newSpell);
//                shootingTimer = System.nanoTime();
//            }
//        }
    }

}
