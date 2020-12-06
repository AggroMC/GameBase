package de.aggromc.testgame.handler;

import de.aggromc.testgame.objects.GameObject;

import java.awt.*;
import java.util.LinkedList;

public class GameHandler {

        public LinkedList<GameObject> objects = new LinkedList<GameObject>();


        public void tick() {
            for (int i = 0; i < objects.size(); i++) {
                objects.get(i).tick();
            }
        }
    public void render(Graphics g) {
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).render(g);
        }
    }

    public void addObject(GameObject object) {
            objects.add(object);
    }

    public void removeObject(GameObject object) {
            objects.remove(object);
    }

}
