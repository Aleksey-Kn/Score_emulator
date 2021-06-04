package com.example.demo.controllers;

import com.example.demo.Config;
import com.example.demo.DataBaseAssistant;
import com.example.demo.dataManagers.Desktop;
import com.example.demo.dataManagers.HardDisk;
import com.example.demo.dataManagers.Monitor;
import com.example.demo.dataManagers.Notebook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    private final ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

    @PostMapping(path = "/uploadDesktop")
    public @ResponseBody String uploadDesktop(@RequestParam("seriesNumber") int seriesNumber,
                                              @RequestParam("maker") String maker,
                                              @RequestParam("price") int price,
                                              @RequestParam("counter") int counter,
                                              @RequestParam("formFactor") String formFactor){
        Desktop desktop = context.getBean(Desktop.class);
        desktop.init(seriesNumber, maker, price, counter, formFactor);
        if(context.getBean(DataBaseAssistant.class).add(desktop)){
            return "Successful";
        } else return "Error in upload";
    }

    @PostMapping(path = "/uploadNotebook")
    public @ResponseBody String uploadNotebook(@RequestParam("seriesNumber") int seriesNumber,
                                               @RequestParam("maker") String maker,
                                               @RequestParam("price") int price,
                                               @RequestParam("counter") int counter,
                                               @RequestParam("size") int size){
        Notebook notebook = context.getBean(Notebook.class);
        notebook.init(seriesNumber, maker, price, counter, size);
        if(context.getBean(DataBaseAssistant.class).add(notebook)){
            return "Successful";
        } else return "Error in upload";
    }

    @PostMapping(path = "/uploadHardDisk")
    public @ResponseBody String uploadHardDisk(@RequestParam("seriesNumber") int seriesNumber,
                                               @RequestParam("maker") String maker,
                                               @RequestParam("price") int price,
                                               @RequestParam("counter") int counter,
                                               @RequestParam("volume") int volume){
        HardDisk hardDisk = context.getBean(HardDisk.class);
        hardDisk.init(seriesNumber, maker, price, counter, volume);
        if(context.getBean(DataBaseAssistant.class).add(hardDisk)){
            return "Successful";
        } else return "Error in upload";
    }

    @PostMapping(path = "/uploadMonitor")
    public @ResponseBody String uploadMonitor(@RequestParam("seriesNumber") int seriesNumber,
                                               @RequestParam("maker") String maker,
                                               @RequestParam("price") int price,
                                               @RequestParam("counter") int counter,
                                               @RequestParam("diagonal") int diagonal){
        Monitor monitor = context.getBean(Monitor.class);
        monitor.init(seriesNumber, maker, price, counter, diagonal);
        if(context.getBean(DataBaseAssistant.class).add(monitor)){
            return "Successful";
        } else return "Error in upload";
    }
}
