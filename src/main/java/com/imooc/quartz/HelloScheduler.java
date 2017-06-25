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
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("The Curr Time is: " + sf.format(date));
        date.setTime(date.getTime() + 3000);

        Date endTime = new Date();
        endTime.setTime(endTime.getTime() + 6000);

        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("myJob", "group1")
                .build();
        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTriger", "group1")
                .withSchedule(
                       CronScheduleBuilder.cronSchedule("* * * * * ?"))
                .build();

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);

        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.shutdown(true);

        System.out.println(scheduler.isShutdown());

    }

}
