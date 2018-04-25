package Model;

import java.awt.image.BufferedImage;

public abstract class GameObject {

    private float xpos;
    private float ypos;
    private float scale;
    private float rotation;
    private BufferedImage sprite;

    GameObject(float xpos, float ypos, float scale, float rotation, BufferedImage sprite){
        this.xpos = xpos;
        this.ypos = ypos;
        this.scale = scale;
        this.rotation = rotation;
        this.sprite = sprite;
    }

    public float getXpos(){
        return xpos;
    }

    public float getYpos(){
        return ypos;
    }

    public float getScale(){
        return scale;
    }

    public float getRotation(){
        return rotation;
    }

    public BufferedImage getSprite(){
        return sprite;
    }

    public void setXpos(float xpos){
        this.xpos = xpos;
    }

    public void setYpos(float ypos){
        this.ypos = ypos;
    }

    public void setScale(float scale){
        this.scale = scale;
    }

    public void setRotation(float rotation){
        this.rotation = rotation;
    }
}
