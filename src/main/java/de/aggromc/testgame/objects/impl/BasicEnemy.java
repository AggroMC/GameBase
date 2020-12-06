package de.aggromc.testgame.objects.impl;

import de.aggromc.testgame.GameBase;
import de.aggromc.testgame.objects.GameObject;
import de.aggromc.testgame.objects.ID;
import de.aggromc.testgame.utils.Texture;

import java.awt.*;

public class BasicEnemy extends GameObject {
    public BasicEnemy(int x, int y) {
        super(x, y, ID.BasicEnemy, new Texture("blue.png"));

        velX = 5;
        velY = 5;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        if (y <= 0 || y >= GameBase.HEIGHT - 16) velY *= -1;

        if (x <= 0 || x >= GameBase.WIDTH - 16) velX *= -1;

        new Trail(x,y,Color.red,16,16,0.1F, null);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x,y,16,16);
        //g.drawImage(texture.getTexture(), x,y, null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,16,16);
    }
}
