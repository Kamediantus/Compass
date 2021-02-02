package ru.appline.controller;

import org.springframework.web.bind.annotation.*;
import ru.appline.logic.Compass;

import java.util.Map;

@RestController
public class Controller {
    private static final Compass compass = Compass.getInstance();

    @PostMapping(value = "/setSides", consumes = "application/json", produces ="application/json")
    public String setSide(@RequestBody Map<String, Integer> side){
        compass.setSides(side);
        return "Соотношение сторон света и диопазона градусов заданы.";
    }
    @GetMapping(value = "/getSide", produces ="application/json", consumes = "application/json")
    public String getSide(@RequestBody Map<String, Integer> degree){
        return compass.getSide(degree.get("Degree"));
    }
//    @GetMapping(value = "/getAll", produces ="application/json", consumes = "application/json")
//    public String getAll() {
//        return compass.getAll();
//    }

}
