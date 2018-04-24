package Model;

import java.awt.image.BufferedImage;

public class Bullet extends GameObject {
    Bullet(float xpos, float ypos, float scale, float rotation, BufferedImage sprite)
    {
        super(xpos, ypos, scale, rotation, sprite);
    }
}
