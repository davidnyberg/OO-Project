package controllers;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import models.*;
import views.*;

public class Controller implements ActionListener
{
  private Model model;
  private View view;
  private ActionListener actionListener;
  
  public Controller(Model model, View view)
  {
    this.model = model;
    this.view = view;
  }
  public void control()
  {
    view.getButton().addActionListener(this);
  }
  private void updateCount()
  {
    model.incrementX();
    view.setText(Integer.toString(model.getX()));
    view.drawSquare();
  }
  public void actionPerformed(ActionEvent actionEvent)
  {
    updateCount();
  }
}