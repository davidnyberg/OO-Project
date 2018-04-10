import controllers.*;
import models.*;
import views.*;

class Example
{
  private static Model model;
  private static View view;
  private static Controller controller;
  
  public static void main(String[] args)
  {  
    model = new Model();
    view = new View("hello world");
    controller = new Controller(model, view);
    controller.control();
  }
}