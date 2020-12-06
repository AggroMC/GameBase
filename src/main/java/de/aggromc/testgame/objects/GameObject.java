package de.aggromc.testgame.objects;

import de.aggromc.testgame.GameBase;
import de.aggromc.testgame.utils.Texture;

import java.awt.*;

public abstract class GameObject {

    protected int x,y;
    protected ID id;
    protected int velX, velY;
    protected Texture texture;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ID getId() {
        return id;
    }

    public int getVelY() {
        return velY;
    }

    public int getVelX() {
        return velX;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    public GameObject(int x, int y, ID id, Texture texture) {
        GameBase.getHandler().addObject(this);
        this.x = x;
        this.y = y;
        this.id = id;

    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

}
