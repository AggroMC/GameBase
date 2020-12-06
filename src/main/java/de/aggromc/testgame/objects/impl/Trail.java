package de.aggromc.testgame.objects.impl;

import de.aggromc.testgame.GameBase;
import de.aggromc.testgame.objects.GameObject;
import de.aggromc.testgame.objects.ID;
import de.aggromc.testgame.utils.Texture;

import java.awt.*;

public class Trail extends GameObject {

    private float alpha = 1, life;
    private Color color;
    private int w,h;

    public Trail(int x, int y, Color c, int w, int h, float life, Texture texture) {
        super(x, y, ID.Trail, texture);
        this.w = w;
        this.h = h;
        this.life = life;
        this.color = c;
    }

    @Override
    public void tick() {
        if (alpha > life) {
            alpha -= life - 0.001;
        }else {
            GameBase.getHandler().removeObject(this);
        }
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));
        g.setColor(color);
        g.fillRect(x,y,w,h);
        g2d.setComposite(makeTransparent(1));
    }

    private AlphaComposite makeTransparent(float alpha) {
        int type = AlphaComposite.SRC_OVER;
        return AlphaComposite.getInstance(type, alpha);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
