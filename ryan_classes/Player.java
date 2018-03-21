class Player extends DynamicObject implements Controllable
{
  private float shootTime;
  private float shootTimer;
  private String shootSprite;
  private boolean isShooting;
  
  public Player()
  {
    super();
    super.setSprite("player");
    super.setDeathSprite("playerDeath");
    shootTime = 1;
    shootTimer = shootTime;
    shootSprite = "playerShoot";
    isShooting = false;
  }
  
  public Player(float x, float y, float s, float th, float sp, float dat, float st)
  {
    super(x, y, s, th, "player", sp, dat, "playerDeath");
    shootTime = st;
    shootTimer = shootTime;
    shootSprite = "playerShootSprite";  //?? could maybe make this static
    isShooting = false;
  }
  
  private void Rotate(float th)
  {
    //rotate player either th degrees, or facing th
  }
  
  private void setIsShooting(boolean shooting)
  {
    isShooting = shooting;
  }
  
  private void setShootTime(float t)
  {
    shootTime = t;
  }
      
  public boolean getIsShooting()
  {
    return isShooting();
  }
  
  public void ShootOnce()
  {
    //create a bullet and send it toward direction aming
  }
  
  // for movable interface
  public void DoMove()
  {
    //move one speed's distance in direction of input
  }
  
  // for controllable interface
  public void GetInput()
  {
    
  }
  
  public void Draw()
  {
    //if player is shooting, draw shooting sprite, else super.Draw();
  }
}