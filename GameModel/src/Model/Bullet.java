package Model;

import java.awt.image.BufferedImage;

public class Bullet extends DynamicObject {
    Bullet(float xpos, float ypos, float scale, float rotation,
            float speed, float deathLength)
    {
        super(xpos, ypos, scale, rotation, "bullet.png", speed, deathLength, "bulletDeath.png");
    }
}
