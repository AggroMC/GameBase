package de.aggromc.testgame;

import de.aggromc.testgame.gui.HUD;
import de.aggromc.testgame.gui.Window;
import de.aggromc.testgame.handler.GameHandler;
import de.aggromc.testgame.handler.KeyInput;
import de.aggromc.testgame.objects.impl.BasicEnemy;
import de.aggromc.testgame.objects.impl.Player;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameBase extends Canvas implements Runnable {

    private static GameHandler handler;
    public static int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

    public static GameHandler getHandler() {
        return handler;
    }

    public synchronized void start() {
        threadPool = Executors.newFixedThreadPool(3);
        threadPool.execute(this);
        gameRunning = true;
    }

    public synchronized void stop() {
        threadPool.shutdown();
        gameRunning = false;
    }

    private ExecutorService threadPool;
    private final HUD hud;
    private boolean gameRunning = false;

    public GameBase() {
        handler = new GameHandler();
        Random random = new Random();
        this.hud = new HUD();
        this.addKeyListener(new KeyInput(handler));

        new Player(WIDTH/2-32, HEIGHT/2-32, null);
        for (int i = 0; i < 20; i++) {
            new BasicEnemy(random.nextInt(WIDTH), random.nextInt(HEIGHT));
        }
        new Window(WIDTH, HEIGHT, "GameBase", this);
    }

    private void tick() {
        handler.tick();
        hud.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0 ,0, GameBase.WIDTH, GameBase.HEIGHT);
        handler.render(g);
        hud.render(g);
        g.dispose();
        bs.show();
    }

    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        final double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (gameRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (gameRunning) {
                render();
            }
            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    public static int clamp(int var, int min, int max) {
        if (var >= max) {
            return max;
        }else
            return Math.max(var, min);

    }


    public static void main(String [] args) {
        new GameBase();
    }

}
