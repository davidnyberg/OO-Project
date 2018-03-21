class Objective extends GameObject
{
  private int points;
  
  public Objective()
  {
    super();
    super.setSprite("objective");
  }
  
  public Objective(float x, float y, float scale, float rotation)
  {
    super(x, y, scale, rotation, "objective");
  }
}