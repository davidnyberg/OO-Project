package Model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class GameObject {

    private float xpos;
    private float ypos;
    private float scale;
    private float rotation;
    private Image sprite;

    GameObject(float xpos, float ypos, float scale, float rotation, String spriteName){
        this.xpos = xpos;
        this.ypos = ypos;
        this.scale = scale;
        this.rotation = rotation;
        this.sprite = loadSprite(spriteName);
    }

    private Image loadSprite(String spriteName)
    {
        Image img = null;
        try{
            String path = System.getProperty("user.dir");

            String OS = System.getProperty("os.name");
            if(OS.startsWith("Windows")) {
                path += "\\sprites\\" + spriteName;
            }
            else{
                path += "/sprites/" + spriteName;
            }

            img = ImageIO.read(new File(path));

        } catch (IOException e) {
            System.out.println(e);
        }
        return img;
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

    public Image getSprite(){
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

    public void render(Graphics g){
        if(sprite != null){
            Graphics2D g2d = (Graphics2D)g;
            AffineTransform old = g2d.getTransform();

            AffineTransform r = AffineTransform.getRotateInstance(getRotation(), (int)getXpos(), (int)getYpos());

            g2d.setTransform(r);

            g2d.drawImage(sprite,(int)getXpos()-((int)getScale()/2), (int)getYpos()-((int)getScale()/2),(int)getScale(),(int)getScale(),null);
            g2d.setTransform(old);
        }
        //default
        else {
            g.setColor(Color.red);
            g.fillRect((int) xpos, (int) ypos, (int) scale, (int) scale);
        }
    }
}
