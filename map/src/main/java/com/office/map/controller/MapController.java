package com.office.map.controller;

import com.office.map.services.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1")
public class MapController {

    private final MapService mapService;

    @Autowired
    public MapController(final MapService mapService){
        this.mapService = mapService;
    }

    @GetMapping(path = "/health")
    public boolean health() {
        return mapService.isHealthy();
    }

    @GetMapping(path = "/prepare")
    public void prepare(){
        mapService.prepare();
    }

    @GetMapping(path = "/ready")
    public boolean ready(){
        return true;
    }
}
