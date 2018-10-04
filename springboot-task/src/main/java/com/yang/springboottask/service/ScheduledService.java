package com.yang.springboottask.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    /**
     * second,minute,hour,day of month,month,day,day of week
     * https://github.com/LauJoeng/Image/blob/master/2018-10/cron%E8%A1%A8%E8%BE%BE%E5%BC%8F.PNG?raw=true
     */
    @Scheduled(cron = "0 * * * * MON-THU")
    public void hello(){
        System.out.println("hello");
    }
}
