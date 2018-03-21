class Bullet extends DynamicObject
{
  public Bullet()
  {
    super();
    super.setSprite("bullet");
    super.setDeathSprite("bulletDeath");
  }
  
  public Bullet(float x, float y, float s, float th, float sp, float dat)
  {
    super(x, y, s, th, "bullet", sp, dat, "bulletDeath");
  }
  
  public void DoMove()
  {
    //move one speed's distance foward
  }
}