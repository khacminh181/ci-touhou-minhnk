import touhou.Inputs.InputManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GameWindow extends JFrame{

    GameCanvas canvas;

    long lastTimeUpdate;

    public GameWindow() {
        this.setSize(800,600);

        //this.setBackground(Color.BLACK);

        this.canvas = new GameCanvas();
        this.setContentPane(this.canvas);// ném canvas vào window
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        this.setResizable(false);// không kéo màn hình

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("keyTyped");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                InputManager.instance.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                InputManager.instance.keyReleased(e);
            }
        });

        this.canvas.setVisible(true);
        this.setVisible(true);

        lastTimeUpdate = System.nanoTime();

    }

    public void gameLoop() {
        while (true) {

            long currentTime = System.nanoTime();

            if (currentTime - lastTimeUpdate >= 17000000) {
                canvas.run();
                canvas.render();
                lastTimeUpdate = currentTime;

            }
        }
    }

}
