package Model;

import java.awt.image.BufferedImage;

public class Enemy extends DynamicObject {

    private float target_x;
    private float target_y;

    Enemy(float xpos, float ypos, float scale, float rotation, BufferedImage sprite,
            float speed, float deathLength, BufferedImage deathSprite)
    {
        super(xpos, ypos, scale, rotation, sprite, speed, deathLength, deathSprite);
        target_x = xpos;
        target_y = ypos;
    }

    public void SetTargetPosition(float x, float y)
    {
        this.target_x = x;
        this.target_y = y;
    }

    public void RotateTowardTarget()
    {
        //do math to find rotation facing toward target from current position
    }
}
