package com.example.demo.controllers;

import com.example.demo.DataBaseAssistant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DownloadController{
    @Autowired
    DataBaseAssistant dataBaseAssistant;

    @GetMapping(path = "/download")
    public @ResponseBody String download(@RequestParam("contact") String concat,
                                         @RequestParam("id") int id){
        try {
            return dataBaseAssistant.searchId(concat, id).toString();
        } catch (IndexOutOfBoundsException e){
            return "Incorrect data";
        }
    }
}
