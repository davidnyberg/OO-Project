package Model;

import javax.imageio.ImageIO;
import javax.sound.midi.SysexMessage;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Wall extends GameObject {

    public Wall(float xpos, float ypos, float scale, float rotation)
    {
        super(xpos, ypos, scale, rotation, "stoneWall.png");
    }
}
