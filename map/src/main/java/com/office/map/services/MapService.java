package com.office.map.services;

import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class MapService {

    private String path = "src\\main\\resources\\static\\pictures\\map.png";

    public boolean isHealthy(){
        File file = new File(path);
        return file.exists() && !file.isDirectory();
    }

    public void prepare(){

    }
}
