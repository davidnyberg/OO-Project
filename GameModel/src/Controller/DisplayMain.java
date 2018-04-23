package Controller;

import View.*;
import Model.*;

public class DisplayMain {

    DisplayMain(){


      SwingMenu menu = new SwingMenu(this);

      //menu

    }


    public void PlayPressed(){
        //.setText("clicked play");
        //set view to the game screen
        new Game();
    }

    public void Leaderboard(){
        new Leadboard(this);
    }

    public void BackButton(){
        new SwingMenu(this);
    }
}
