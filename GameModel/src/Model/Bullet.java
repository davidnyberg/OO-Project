package Model;

import java.awt.image.BufferedImage;

import static java.lang.Math.*;

public class Bullet extends DynamicObject {
    public Bullet(float xpos, float ypos, float scale, float rotation,
            float speed, float deathLength)
    {
        super(xpos, ypos, scale, rotation, "bullet.png", speed, deathLength, "bulletDeath.png");
    }


    public void MoveInDirection()
    {
        float dx = (float) (1*cos(this.getRotation()));
        float dy = (float) (1*sin(this.getRotation()));

        this.setXpos(this.getXpos() + (dx * getSpeed()));
        this.setYpos(this.getYpos() + (dy * getSpeed()));
    }
}
