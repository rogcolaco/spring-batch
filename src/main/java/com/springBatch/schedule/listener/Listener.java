package com.springBatch.schedule.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Listener implements JobExecutionListener {

    Logger log = LoggerFactory.getLogger(Listener.class);

    public void beforeJob(JobExecution jobExecution) {
        log.info("-> Start job");
    }

    public void afterJob(JobExecution jobExecution){
        if(jobExecution.getStatus() == BatchStatus.COMPLETED){
            log.info("-> End job with success");
        }
    }


}
