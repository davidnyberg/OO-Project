package Model;

import javax.imageio.ImageIO;
import javax.sound.midi.SysexMessage;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Wall extends GameObject {

    public Wall(float xpos, float ypos, float scale, float rotation, BufferedImage sprite)
    {
        super(xpos, ypos, scale, rotation, sprite);
    }

    @Override
    public void render(Graphics g) {
        Image img = null;
        try{
            img = ImageIO.read(new File("/Users/davidnyberg/Desktop/turtle.png"));

        } catch (IOException e) {
            System.out.println(e);
            }

            g.drawImage(img,(int)getXpos(), (int)getYpos(),40,40,null);
    }
}
