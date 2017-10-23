package touhou.players;

import bases.GameObject;
import bases.Utils;
import bases.Vector2D;
import bases.physics.BoxCollieder;

import java.awt.event.KeyEvent;

public class Player extends GameObject {

    boolean rightPressed;
    boolean leftPressed;
    boolean downPressed;
    boolean upPressed;

    boolean xPressed;

    final int SPEED = 5; // final = const

    public int hP = 5;

    public BoxCollieder boxCollieder;

    final int LEFT = 0;
    final int RIGHT = 384;
    final int TOP = 0;
    final int BOTTOM = 550;

//    long shootingTimer = System.nanoTime();
//    long shootingDelay = 100;

    boolean spellDisabled = false;
    final int COOL_DOWN_TIME = 10;

    public Player() {
        position.x = 182;
        position.y = 520;
        image = Utils.loadImage("assets/images/players/straight/0.png");
        boxCollieder = new BoxCollieder(30, 30);
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
        boxCollieder.position.set(this.position);
    }

    Vector2D velocity = new Vector2D();

    private void move() {
        velocity.set(0, 0);

        if (rightPressed) {
            velocity.x += SPEED;
        }

        if (leftPressed) {
            velocity.x -=SPEED;
        }

        if (downPressed) {
            velocity.y += SPEED;
        }

        if (upPressed) {
            velocity.y -= SPEED;
        }

        position.addUp(velocity);

        position.x = (int)Utils.clamp(position.x, LEFT, RIGHT);
        position.y = (int)Utils.clamp(position.y, TOP, BOTTOM);
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
            newSpell.position.set(this.position);

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

    public void getHit() {
        isActive = false;
    }



}
