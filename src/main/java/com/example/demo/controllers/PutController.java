package com.example.demo.controllers;

import com.example.demo.DataBaseAssistant;
import com.example.demo.dataManagers.Desktop;
import com.example.demo.dataManagers.HardDisk;
import com.example.demo.dataManagers.Monitor;
import com.example.demo.dataManagers.Notebook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PutController {
    @Autowired
    DataBaseAssistant dataBaseAssistant;

    @PostMapping(path = "/putDesktop")
    public @ResponseBody String putDesktop(@RequestParam("id") int id,
                                           @RequestParam("seriesNumber") int seriesNumber,
                                           @RequestParam("maker") String maker,
                                           @RequestParam("price") int price,
                                           @RequestParam("counter") int counter,
                                           @RequestParam("formFactor") String formFactor){
        if(dataBaseAssistant.set(id, new Desktop(seriesNumber, maker, price, counter, formFactor))){
            return "Successful";
        } else return "Error in upload";
    }

    @PostMapping(path = "/putHardDisk")
    public @ResponseBody String putHardDisk(@RequestParam("id") int id,
                                           @RequestParam("seriesNumber") int seriesNumber,
                                           @RequestParam("maker") String maker,
                                           @RequestParam("price") int price,
                                           @RequestParam("counter") int counter,
                                           @RequestParam("volume") int volume){
        if(dataBaseAssistant.set(id, new HardDisk(seriesNumber, maker, price, counter, volume))){
            return "Successful";
        } else return "Error in upload";
    }

    @PostMapping(path = "/putMonitor")
    public @ResponseBody String putMonitor(@RequestParam("id") int id,
                                           @RequestParam("seriesNumber") int seriesNumber,
                                           @RequestParam("maker") String maker,
                                           @RequestParam("price") int price,
                                           @RequestParam("counter") int counter,
                                           @RequestParam("diagonal") int diagonal){
        if(dataBaseAssistant.set(id, new Monitor(seriesNumber, maker, price, counter, diagonal))){
            return "Successful";
        } else return "Error in upload";
    }

    @PostMapping(path = "/putNotebook")
    public @ResponseBody String putNotebook(@RequestParam("id") int id,
                                           @RequestParam("seriesNumber") int seriesNumber,
                                           @RequestParam("maker") String maker,
                                           @RequestParam("price") int price,
                                           @RequestParam("counter") int counter,
                                           @RequestParam("size") int size){
        if(dataBaseAssistant.set(id, new Notebook(seriesNumber, maker, price, counter, size))){
            return "Successful";
        } else return "Error in upload";
    }
}
