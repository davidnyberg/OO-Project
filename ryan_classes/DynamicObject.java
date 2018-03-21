abstract class DynamicObject extends GameObject implements Movable
{
  private float speed;
  private boolean isDead;
  private float deathAnimationTime;
  private float deathAnimationTimer;
  private String deathSprite;
  
  public DynamicObject()
  {
    super();
    super.setSprite("dynamic");
    speed = 1;
    isDead = false;
    deathAnimationTime = 1;
    deathAnimationTimer = deathAnimationTime;
    deathSprite = "empty"
  }
  
  public DynamicObject(float x, float y, float s, float th, String sprt, float sp, float dat, String dSprt)
  {
    super(x, y, s, th, "dynamic");
    speed = sp;
    isDead = false;
    deathAnimationTime = dat;
    deathAnaimationTimer = deathAnimationTime;
    deathSprite = dSprt;
  }
  
  protected void MoveToward(float x, float y)
  {
    //move object's position to one speed's distance toward the target
    
  }
  
  protected void setDeathSprite(String dSprt)
  {
    deathAnimationSprite = dSprt;
  }
  
  public boolean getIsDead()
  {
    return isDead;
  }
  
  public void Draw()
  {
    //check if dying, if so, draw deathAnimation, else super.Draw();
  }
}