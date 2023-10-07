package com.springBatch.schedule.step;

import com.springBatch.schedule.entity.Schedule;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ScheduleStepConfig {

    @Autowired
    PlatformTransactionManager transactionManager;

    @Bean
    public Step scheduleStep(
            JobRepository jobRepository,
            ItemReader<Schedule> itemReader,
            ItemWriter<Schedule> itemWriter
    ){
        return new StepBuilder("scheduleStep", jobRepository)
                .<Schedule, Schedule>chunk(1, transactionManager)
                .reader(itemReader)
                .writer(itemWriter)
                .build();
    }

}
