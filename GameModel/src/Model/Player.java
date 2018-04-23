package Model;

import java.awt.image.BufferedImage;

public class Player extends GameObject {
    private float moveSpeed;
    private float shootSpeed;
    private boolean isDead;

    public Player(float xpos, float ypos, float scale, float rotation, BufferedImage sprite,
           float moveSpeed, float shootSpeed){
        super(xpos,ypos,scale,rotation,sprite);
        this.moveSpeed = moveSpeed;
        this.shootSpeed = shootSpeed;
        this.isDead = false;
    }

    public float getMoveSpeed(){
        return moveSpeed;
    }
    public float getShootSpeed(){
        return shootSpeed;
    }
    public boolean getIsDead(){
        return isDead;
    }

    public void setMoveSpeed(float moveSpeed){
        this.moveSpeed = moveSpeed;
    }

    public void setShootSpeed(float shootSpeed){
        this.shootSpeed = shootSpeed;
    }
    public void setMoveSpeed(boolean isDead){
        this.isDead = isDead;
    }
}
