package Controller;

import Model.*;
import View.GameView;

import java.awt.image.BufferedImage;

public class Game {
    private Player player;
    private BufferedImage a;

    Game() {
       GameView view = new GameView(this);
       player = new Player(0,0,1,0, a, 1,1);

    }

    public void GameLoop(){
        //start game loop
        while (true){

            //keyboard controls,
            //
        }
    }
}
