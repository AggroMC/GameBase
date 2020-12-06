package de.aggromc.testgame.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Texture {

    private BufferedImage texture;

    public Texture(String location) {
        try {
            texture = ImageIO.read(new File("textures/"+ location + ".png"));
        }catch (Exception e) {
            texture = null;
        }
    }

    public BufferedImage getTexture() {
        return texture;
    }
}
