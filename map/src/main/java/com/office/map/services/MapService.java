package com.office.map.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Service
public class MapService {

    private String path = "src\\main\\resources\\static\\pictures\\";

    @Value("${office1.desk01}")
    private String colleague01;
    @Value("${office1.desk02}")
    private String colleague02;

    public boolean isHealthy(){
        final File file = new File(path + "map.png");
        return file.exists() && !file.isDirectory();
    }

    public void prepare(){
        try {
            final BufferedImage bufImg = ImageIO.read(new File(path + "map.png"));
            final Graphics2D graphics = (Graphics2D) bufImg.getGraphics();

            graphics.setColor(Color.BLACK);
            graphics.drawString(colleague01,325,500);
            graphics.drawString(colleague02,325,516);

            ImageIO.write(bufImg,"png",new File(path + "namesmap.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isReady(){
        final File file = new File(path + "namesmap.png");
        return file.exists() && !file.isDirectory();
    }
}
