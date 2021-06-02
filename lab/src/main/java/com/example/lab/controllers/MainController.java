package com.example.lab.controllers;


import com.example.lab.models.mainModel;
import com.example.lab.models.Repository;
import com.example.lab.services.Service;
import com.example.lab.services.serviceMessage;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;


@Controller
public class MainController {
    static Logger logger = LogManager.getLogger(MainController.class);
    Repository<mainModel> repository =new Repository();
    String message=new String();
    private Thread thread = serviceMessage.createThread();
    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("NumberModel", new mainModel());
        model.addAttribute("message", message);
        return "main";
    }

    @PostMapping("/")
    public String changeSubmit(mainModel number, Model model, @RequestParam String action){

        Service.numberOperation(action, number);

        model.addAttribute("NumberModel", number);
        repository.create(number);


        if(action.equals("delete"))
        {
            repository.deleteAll();
            thread.interrupt();
            thread = serviceMessage.createThread();
        }

        if(action.equals("sort")){
            Collections.sort(repository.readAll());
        }

        model.addAttribute("message", serviceMessage.genMessage(repository));
        System.out.println(number.getStr1());
        logger.log(Level.INFO,number.getStr1());
        return "main";
    }

}
