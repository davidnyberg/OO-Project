package models;

public class Model
{
  private int x;
  
  public Model()
  {
    x = 0;
  }
  public void incrementX()
  {
    x++;
    //save to database
  }
  public int getX()
  {
    return x;
  }
}