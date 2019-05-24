package com.office.map.services;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "office")
public class OfficeList {

    private Map<Integer,String> seating = new HashMap<>();

    public Map<Integer, String> getSeating() {
        return seating;
    }
}
