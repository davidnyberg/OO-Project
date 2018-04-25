package Model;

import java.awt.image.BufferedImage;

public class Bullet extends DynamicObject {
    Bullet(float xpos, float ypos, float scale, float rotation, BufferedImage sprite,
            float speed, float deathLength, BufferedImage deathSprite)
    {
        super(xpos, ypos, scale, rotation, sprite, speed, deathLength, deathSprite);
    }
}
