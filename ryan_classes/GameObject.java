abstract class GameObject implements Drawable
{
  private float xpos;
  private float ypos;
  private float rotation;
  private float scale;
  private String sprite;
  
  public void getPosition(float *x, float *y)
  {
    *x = xpos;
    *y = ypos;
  }  
  protected void setPosition(float x, float y)
  {
    xpos = x;
    ypos = y;
  } 
  protected float getRotation()
  {
    return rotation;
  }
  protected void setRotation(float th)
  {
    rotation = th;
  }
  protected void setSprite(string address)
  {
    sprite = address;
  }
  
  public GameObject()
  {
    setPosition(0, 0);
    setRotation(0);
    scale = 1;
    setSprite("empty");
  }
  
  public GameObject(float x, float y, float s, float th, String sp)
  {
    setPosition(x, y);
    setRotation(th);
    scale = s;
    setSprite(sp);
  }
  
  public void Draw()
  {
    //search for sprite name and draw in xpos ypos
  }
}