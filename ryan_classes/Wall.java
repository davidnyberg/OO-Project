class Wall extends GameObject
{
  public Wall()
  {    
    super();
    super.setSprite("wall");
  }
  
  public Wall(float x, float y, float scale, float rotation)
  {
    super(x, y, scale, rotation, "wall");
  }
  public boolean checkCollision(GameObject checkAgainst)
  {
    if (this.ypos == checkAgainst.ypos) && (this.xpos == checkAgainst.xpos){//should depend on the size of the sprite of checkAgainst
      return true;
    }
    return false;
  }
}
