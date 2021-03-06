package Model;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import static java.lang.Math.sqrt;

public abstract class DynamicObject extends GameObject {

  private float speed;
  private boolean isDead;
  private float deathTimer;
  private Image deathSprite;


  private int lastXpos;
  private int lastYpos;

  public DynamicObject(float x, float y, float scale, float rotation, String spriteName,
                       float speed, float deathLength, String deathSpriteName)
  {
    super(x, y, scale, rotation, spriteName);
    this.speed = speed;
    this.deathTimer = deathLength;
    this.deathSprite = loadSprite(deathSpriteName);
    this.isDead = false;
  }

  public float getSpeed(){return speed;}
  public boolean getIsDead(){return isDead;}

  public void setSpeed(float s){this.speed = s;}
  public void setIsDead(boolean d){this.isDead = d;}

  public boolean checkDeathTime()
  {
    if(isDead) {
      if (deathTimer <= 0)
        return true;
      deathTimer--;
    }
    return false;
  }

  public void MoveInDirection(float x, float y)
  {
    if(x == 0 && y == 0)
      return;

    float mag = (float)sqrt(x*x + y*y);
    float nx = x / mag;
    float ny = y / mag;
    this.setXpos(this.getXpos() + (nx * speed));
    this.setYpos(this.getYpos() + (ny * speed));
  }

  public void render(Graphics g)
  {
    if(isDead) {
      if(deathSprite != null) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform old = g2d.getTransform();
        AffineTransform r = AffineTransform.getRotateInstance(getRotation(), (int) getXpos(), (int) getYpos());
        g2d.setTransform(r);
        g2d.drawImage(deathSprite, (int) getXpos() - ((int) getScale() / 2), (int) getYpos() - ((int) getScale() / 2), (int) getScale(), (int) getScale(), null);
        g2d.setTransform(old);
      }
      else{
        g.setColor(Color.red);
        g.fillRect((int) getXpos()- ((int) getScale() / 2), (int) getYpos()- ((int) getScale() / 2), (int) getScale(), (int) getScale());
      }
    }
    else
      super.render(g);
  }
}
