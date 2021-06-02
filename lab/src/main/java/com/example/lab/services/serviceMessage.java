package com.example.lab.services;

import com.example.lab.services.Service;
import com.example.lab.models.Repository;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class serviceMessage {

    static Logger logger = LogManager.getLogger(serviceMessage.class);

    public static<T> String genMessage(Repository<T> repository)
    {
        String message;
        message="Все значения:"+repository.toString();
        return message;
    }

    public static Thread createThread(){
        Runnable task = () ->{
            try {
                while(!Thread.currentThread().isInterrupted()) {
                    logger.log(Level.INFO, Thread.currentThread().getName());
                    Thread.currentThread().sleep(1000 * 1);
                }
            }catch (InterruptedException e){
                logger.log(Level.ERROR,"Interrupted exception acquired");
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(task);
        thread.start();
        return thread;
    }


}
