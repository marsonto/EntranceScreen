package com.office.map.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class MapService {

    private static final String PATH = "src\\main\\resources\\static\\pictures\\";

    private final OfficeList officeList;

    @Autowired
    public MapService(final OfficeList officeList) {
        this.officeList = officeList;
    }

    public boolean isHealthy(){
        final File file = new File(PATH + "map.png");
        return file.exists() && !file.isDirectory() && !officeList.getSeating().isEmpty();
    }

    public void prepare(){
        try {
            final BufferedImage bufImg = ImageIO.read(new File(PATH + "map.png"));
            final Graphics2D graphics = (Graphics2D) bufImg.getGraphics();
            final int startingX = 350;
            final int startingY = 510;
            final int space = 16;

            final Map<Integer,String> seating = officeList.getSeating();
            graphics.setColor(Color.BLACK);

            final double sizeInDouble = seating.size();
            for (int i = 1; i <= seating.size(); i++){
                if (i <= Math.ceil(sizeInDouble/3)) {
                    graphics.drawString(i + ". " + seating.get(i), startingX, startingY + i * space);
                } else if (i <= Math.ceil(sizeInDouble/3*2)){
                    graphics.drawString(i + ". " + seating.get(i), startingX + 175, startingY + (i - (int) Math.ceil(sizeInDouble/3))*space);
                } else {
                    graphics.drawString(i + ". " + seating.get(i), startingX + 350, startingY + (i - (int) Math.ceil(sizeInDouble/3*2))*space);
                }
            }

            ImageIO.write(bufImg,"png",new File(PATH + "namesmap.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isReady(){
        final File file = new File(PATH + "namesmap.png");
        return file.exists() && !file.isDirectory();
    }
}
