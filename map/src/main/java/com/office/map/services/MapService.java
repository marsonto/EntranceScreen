package com.office.map.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class MapService {

    @Value("$(file.path)")
    private String path;

    public boolean isHealthy(){
        File file = new File(path);
        return file.exists() && !file.isDirectory();
    }
}
