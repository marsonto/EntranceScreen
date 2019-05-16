package com.office.map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/")
public class MapController {

    @Autowired
    public MapController(){}

    @GetMapping(path = "health")
    public boolean health() {
        return true;
    }

    @GetMapping(path = "prepare")
    public void prepare(){}

    @GetMapping(path = "ready")
    public boolean ready(){
        return true;
    }

    @GetMapping(path = "")
    public void map(){}
}
