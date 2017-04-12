package com.mn.scheduler;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DemoService
{
    @Scheduled(cron="*/5 * * * * ?")
    public void demoServiceMethod()
    {
        System.out.println("Server running. Current time: "+ new Date());
    }
}
