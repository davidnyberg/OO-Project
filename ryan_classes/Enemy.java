class Enemy extends DynamicObject
{
  private float target_x;
  private float target_y;
 
  public Enemy()
  {
    super();
    super.setSprite("enemy");
    super.setDeathSprite("enemyDeath");
    setTargetPosition(0, 0);
  }
   
  public Enemy(float x, float y, float s, float th, float sp, float dat, float tx, float ty)
  {
    super(x, y, s, th, "enemy", sp, dat, "enemyDeath");
    setTargetPosition(tx, ty);
  }
 
  public void SetTargetPosition(float x, float y)
  {
    target_x = x;
    target_y = y;
  }
  
  public void RotateTowardTarget()
  {
    //rotate toward stored target
  }
  
  public void DoMove()
  {
    //move one speed toward target
  }
}