package Model;

import java.awt.image.BufferedImage;

public class Player extends DynamicObject {
    private float shootSpeed;

    public Player(float xpos, float ypos, float scale, float rotation,
                  float speed, float deathLength,
                  float shootSpeed){

        super(xpos, ypos, scale, rotation, "player.png", speed, deathLength, "playerDeath.png");
        this.shootSpeed = shootSpeed;
    }

    public float getShootSpeed(){
        return shootSpeed;
    }

    public void setShootSpeed(float shootSpeed){
        this.shootSpeed = shootSpeed;
    }

}
