package com.example.demo.controllers;

import com.example.demo.DataBaseAssistant;
import com.example.demo.dataManagers.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScanController {
    @Autowired
    DataBaseAssistant dataBaseAssistant;

    @GetMapping(path = "/print")
    public @ResponseBody String download(@RequestParam("contact") String concat){
        List<Data> data = dataBaseAssistant.getAll(concat);
        StringBuilder result = new StringBuilder();
        data.forEach(o -> result.append(o.toString()).append("<br>"));
        return result.toString();
    }
}
