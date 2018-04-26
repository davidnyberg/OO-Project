package Model;

import java.awt.image.BufferedImage;

public class Enemy extends DynamicObject {

    private float target_x;
    private float target_y;

    public Enemy(float xpos, float ypos, float scale, float rotation,
            float speed, float deathLength)
    {
        super(xpos, ypos, scale, rotation, "enemy.png", speed, deathLength, "enemyDeath.png");
        target_x = xpos;
        target_y = ypos;
    }

    public void SetTargetPosition(float x, float y)
    {
        this.target_x = x;
        this.target_y = y;
    }

    public void moveTowardTarget(){
        MoveInDirection(target_x - getXpos(), target_y - getYpos());
    }

    public void RotateTowardTarget()
    {
        //do math to find rotation facing toward target from current position
    }
}
