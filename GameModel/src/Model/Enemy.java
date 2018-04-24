package Model;

import java.awt.image.BufferedImage;

public class Enemy extends GameObject {
    Enemy(float xpos, float ypos, float scale, float rotation, BufferedImage sprite)
    {
        super(xpos, ypos, scale, rotation, sprite);
    }
}
