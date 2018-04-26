package Model;

import java.awt.*;
import java.awt.image.BufferedImage;

import static java.lang.Math.sqrt;

public abstract class DynamicObject extends GameObject {

  private float speed;
  private boolean isDead;
  private float deathLength;
  private float deathTimer;
  private Image deathSprite;



  public DynamicObject(float x, float y, float scale, float rotation, String spriteName,
                       float speed, float deathLength, String deathSpriteName)
  {
    super(x, y, scale, rotation, spriteName);
    this.speed = speed;
    this.deathLength = deathLength;
    this.deathTimer = deathTimer;
    this.deathSprite = deathSprite;
    this.isDead = false;
  }

  public float getSpeed(){return speed;}
  public boolean getIsDead(){return isDead;}

  public void setSpeed(float s){this.speed = s;}
  public void setIsDead(boolean d){this.isDead = d;}

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
}
