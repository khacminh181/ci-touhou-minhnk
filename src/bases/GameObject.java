package bases;

import bases.physics.BoxCollieder;
import bases.physics.PhysicsBody;
import touhou.enemies.Enemy;
import touhou.players.Player;
import touhou.players.PlayerSpell;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class GameObject {
    public Vector2D position;
    public BufferedImage image;
    public boolean isActive;


    static Vector<GameObject> gameObjects = new Vector<>();
    static Vector<GameObject> newGameObjects = new Vector<>();

    public static void runAll() {
        for (GameObject gameObject: gameObjects) {
            if (gameObject.isActive) {
                gameObject.run();
            }
        }

        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
    }

    public static void renderAll(Graphics g) {
        for (GameObject gameObject: gameObjects) {
            if (gameObject.isActive) {
                gameObject.render(g);

            }
        }
    }

    public static void add(GameObject gameObject) {
        newGameObjects.add(gameObject);
    }

    // Tim trong tat ca cac game object
    // Neu gap 1 object thoa man 2 dieu kien :
    // 1. Game object nay la playerspell
    // 2. isActive == false
    // thi return object nay
    // neu khong tim thay
    // Tu khoi tao 1 PlayerSpell moi => return
    public static <T extends GameObject>T recycle(Class<T> cls) {
        for (GameObject gameObject : gameObjects) {
            if (!(gameObject.getClass().equals(cls))) continue;
            if (!gameObject.isActive) {
                (gameObject).isActive = true;
                return (T) gameObject;
            }
        }

        try {
            T newGameObject = cls.newInstance(); // = new
            add(newGameObject);
            return newGameObject;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T extends PhysicsBody> T collideWith(BoxCollieder boxCollieder, Class<T> cls) {
        for (GameObject gameObject : gameObjects) {
           if (!gameObject.isActive) continue;
           if (!(gameObject instanceof PhysicsBody)) continue;
           if (!(gameObject.getClass().equals(cls))) continue;

           BoxCollieder otherBoxCollider = ((PhysicsBody) gameObject).getBoxCollider();
           if (otherBoxCollider.collideWith(boxCollieder)) {
               return (T)gameObject;
           }
        }

        return null;
    }

    public GameObject() {
        position = new Vector2D();
        isActive = true;
    }

    public void run() {

    }

    public void render(Graphics g) {
        if (image != null) {
            g.drawImage(
                    image,
                    (int)(position.x - image.getWidth() / 2),
                    (int)(position.y - image.getHeight() / 2),
                    null);
        }
    }
}
