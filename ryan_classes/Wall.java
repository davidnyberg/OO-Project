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
}