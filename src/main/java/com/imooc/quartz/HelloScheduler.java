package com.imooc.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zzy on 2017/6/20.
 */
public class HelloScheduler {
    public static void main(String args[]) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("myJob","group1").build();
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTriger","group1")
                .startNow()
                .withSchedule(
                        SimpleScheduleBuilder
                        .simpleSchedule()
                        .withIntervalInSeconds(2)
                        .repeatForever())
                .build();

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("The Exec Time is: "+sf.format(date));
        scheduler.scheduleJob(jobDetail,trigger);

    }

}
