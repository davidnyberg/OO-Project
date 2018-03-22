class Bullet extends DynamicObject
{
  public float velocity;
  public Bullet(float v)
  {
    super();
    super.setSprite("bullet");
    super.setDeathSprite("bulletDeath");
    this.velocity = v
  }
  
  public Bullet(float x, float y, float s, float th, float sp, float dat, float v)
  {
    super(x, y, s, th, "bullet", sp, dat, "bulletDeath");
    this.velocity = v;
  }
  
  public void DoMove()
  {
    //move one speed's distance foward
  }
  public boolean checkPlayerDeath(Enemy E){
    //check this against enemy position, if overlap, kill the player.
    if (this.ypos == E.ypos) && (this.xpos == E.xpos){//should depend on the size of the sprites
      return true;
    }
    return false;
    //probably change the function name, as player shoots bullets at enemies
  }
}
