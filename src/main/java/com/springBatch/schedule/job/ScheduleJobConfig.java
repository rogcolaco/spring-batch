package com.springBatch.schedule.job;

import com.springBatch.schedule.listener.Listener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScheduleJobConfig {

    @Bean
    public Job scheduleJob(JobRepository jobRepository, Step scheduleStep, Listener listener){
        return new JobBuilder("scheduleJob", jobRepository)
                .start(scheduleStep)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .build();
    }

}
