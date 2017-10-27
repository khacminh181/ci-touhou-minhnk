package touhou.players;

import bases.GameObject;
import bases.Utils;
import bases.Vector2D;
import touhou.Inputs.InputManager;

import java.awt.image.BufferedImage;

public class Sphere extends GameObject{

    // Sphere shoot
    boolean spellDisabled = false;
    final int COOL_DOWN_TIME = 50;
    int coolDownCount;
    final int SPEED = 5; // final = const




    public Sphere() {
        image = Utils.loadImage("assets/images/sphere/0.png");
    }



    public void run (float x, float y) {
        position.set(x, y);
        shoot();
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
    }

    private void shoot() {

        if (spellDisabled) {
            coolDownCount++;
            if (coolDownCount >= COOL_DOWN_TIME) {
                spellDisabled = false;
                coolDownCount = 0;
            }
            return;
        }

        if (InputManager.instance.xPressed) {
            SphereBullet newSphereBullet = GameObject.recycle(SphereBullet.class);
            newSphereBullet.position.set(this.position);

            spellDisabled = true;
        }

    }



}
