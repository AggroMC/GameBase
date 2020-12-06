package de.aggromc.testgame.handler;

import de.aggromc.testgame.objects.GameObject;
import de.aggromc.testgame.objects.ID;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private GameHandler gameHandler;

    public KeyInput(GameHandler gameHandler) {
        this.gameHandler = gameHandler;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
        for (int i = 0; i < gameHandler.objects.size(); i++) {
            GameObject o = gameHandler.objects.get(i);
            if (o.getId() == ID.Player) {
                int multiplier = 10;
                if (key == KeyEvent.VK_W) {
                    //o.setY(o.getY() - 1);
                    o.setVelY(-multiplier);
                }else if (key == KeyEvent.VK_A) {
                    o.setVelX(-multiplier);
                }else if (key == KeyEvent.VK_S) {
                    o.setVelY(multiplier);
                }else if (key == KeyEvent.VK_D) {
                    o.setVelX(multiplier);
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < gameHandler.objects.size(); i++) {
            GameObject o = gameHandler.objects.get(i);
            if (o.getId() == ID.Player) {
                if (key == KeyEvent.VK_W) {
                    //o.setY(o.getY() - 1);
                    o.setVelY(0);
                } else if (key == KeyEvent.VK_A) {
                    o.setVelX(0);
                } else if (key == KeyEvent.VK_S) {
                    o.setVelY(0);
                } else if (key == KeyEvent.VK_D) {
                    o.setVelX(0);
                }
            }
        }
    }



}
