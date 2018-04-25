package Model;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Wall extends GameObject {
    
    public Wall(float xpos, float ypos, float scale, float rotation, BufferedImage sprite)
    {
        super(xpos, ypos, scale, rotation, sprite);
    }

}
