package Model;

import java.awt.image.BufferedImage;

public class Player extends DynamicObject {
    private float shootSpeed;

    public Player(float xpos, float ypos, float scale, float rotation, BufferedImage sprite,
                  float speed, float deathLength, BufferedImage deathSprite,
                  float shootSpeed){

        super(xpos, ypos, scale, rotation, sprite, speed, deathLength, deathSprite);
        this.shootSpeed = shootSpeed;
    }

    public float getShootSpeed(){
        return shootSpeed;
    }

    public void setShootSpeed(float shootSpeed){
        this.shootSpeed = shootSpeed;
    }
}
