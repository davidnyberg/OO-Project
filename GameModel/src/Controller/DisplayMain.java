package Controller;

import View.*;
import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

import static java.awt.Color.black;


public class DisplayMain {

    JFrame window;

    DisplayMain(){

      //init window
      window = new JFrame();
      window.setBackground(Color.red);
      window.setSize(700, 400);
      window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      window.setResizable(true);
      window.setVisible(true);

      //create view
      new MainMenuView(window, this);
    }

    DisplayMain(JFrame preWindow){

      window = preWindow;
      window.setBackground(Color.red);
      window.setSize(700, 400);
      window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      window.setResizable(true);
      window.setVisible(true);

      //create view
      new MainMenuView(window, this);
    }


    public void PlayPressed(){
        //.setText("clicked play");
        //set view to the game screen
        new Game(window);
    }

    public void Leaderboard(){
        new LeaderboardView(window, this);
    }

    public void BackButton(){
        new MainMenuView(window, this);
    }

    public static void main(String[] args) {
      //JFrame frame = new JFrame();
      new DisplayMain();

      //this was in a model named Main. Not sure if it should go here or not.
      DataBase con = new DataBase();
      con.getScore();
    }
}
