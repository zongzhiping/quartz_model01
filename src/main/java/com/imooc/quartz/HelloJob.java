package com.imooc.quartz;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zzy on 2017/6/20.
 */
public class HelloJob implements Job {

    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            Thread.sleep(2000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("The Exec Time is: "+sf.format(date));
        System.out.println("Hello World!");

    }
}
