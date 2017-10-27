package touhou.players;

import bases.GameObject;
import bases.Utils;
import bases.Vector2D;
import bases.physics.BoxCollieder;
import bases.physics.PhysicsBody;
import touhou.Inputs.InputManager;

import java.awt.event.KeyEvent;

public class Player extends GameObject implements PhysicsBody{

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


    PlayerCastSpell playerCastSpell;

    Sphere sphereLeft;
    Sphere sphereRight;

    public Player() {
        // PlayerCastSpell
        playerCastSpell = new PlayerCastSpell();

        //Sphere
        sphereLeft = new Sphere();
        sphereRight = new Sphere();

        position.x = 182;
        position.y = 520;
        image = Utils.loadImage("assets/images/players/straight/0.png");
        boxCollieder = new BoxCollieder(8, 8);
    }


    public void run() {
        move();

        playerCastSpell.run(this);

        GameObject.add(sphereLeft);
        GameObject.add(sphereRight);
        sphereLeft.run(this.position.x - 25, this.position.y);
        sphereRight.run(this.position.x + 25, this.position.y);

        boxCollieder.position.set(this.position);
    }

    Vector2D velocity = new Vector2D();

    private void move() {
        velocity.set(0, 0);

        InputManager inputManager = InputManager.instance;

        if (inputManager.rightPressed) {
            velocity.x += SPEED;
        }

        if (inputManager.leftPressed) {
            velocity.x -=SPEED;
        }

        if (inputManager.downPressed) {
            velocity.y += SPEED;
        }

        if (inputManager.upPressed) {
            velocity.y -= SPEED;
        }

        position.addUp(velocity);

        position.x = (int)Utils.clamp(position.x, LEFT, RIGHT);
        position.y = (int)Utils.clamp(position.y, TOP, BOTTOM);
    }


    public void getHit() {
        isActive = false;
        //TODO : Change screen to Gameover
    }


    @Override
    public BoxCollieder getBoxCollider() {
        return boxCollieder;
    }
}
