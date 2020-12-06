package de.aggromc.testgame.gui;

import de.aggromc.testgame.GameBase;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {

    public Window(final int width, final int height, final String windowTitle, GameBase game) {
        JFrame window = new JFrame();
        window.setTitle(windowTitle);
        Dimension windowSize = new Dimension(width, height);
        window.setPreferredSize(windowSize);
        window.setMinimumSize(windowSize);
        window.setMaximumSize(windowSize);
        window.setUndecorated(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.add(game);
        window.setVisible(true);
        game.start();


    }


}
