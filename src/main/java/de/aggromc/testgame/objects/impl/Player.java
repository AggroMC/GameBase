package de.aggromc.testgame.objects.impl;

import de.aggromc.testgame.GameBase;
import de.aggromc.testgame.gui.HUD;
import de.aggromc.testgame.objects.GameObject;
import de.aggromc.testgame.objects.ID;
import de.aggromc.testgame.utils.Texture;

import java.awt.*;

public class Player extends GameObject {


    public Player(int x, int y, Texture texture) {
        super(x, y, ID.Player, texture);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        if (x < 1) {
            x = 0;
        }
        if (x > GameBase.WIDTH - 32) {
            x = GameBase.WIDTH - 32;
        }
        if (y > GameBase.HEIGHT - 32) {
            y = GameBase.HEIGHT - 32;
        }
        if (y < 1) {
            y = 0;
        }
        collision();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x,y,32,32);
    }

    private void collision() {
        for (int i = 0; i < GameBase.getHandler().objects.size(); i++) {
            if (GameBase.getHandler().objects.get(i).getId() == ID.BasicEnemy) {
                if (getBounds().intersects(GameBase.getHandler().objects.get(i).getBounds())) {
                    HUD.HEALTH -= 2;
                }
            }
        }
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,32,32);
    }
}
