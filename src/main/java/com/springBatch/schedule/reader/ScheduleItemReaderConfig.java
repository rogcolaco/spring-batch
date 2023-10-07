package com.springBatch.schedule.reader;

import com.springBatch.schedule.entity.Schedule;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class ScheduleItemReaderConfig {

    @Bean
    public ItemReader<Schedule> itemReader (){
        return new FlatFileItemReaderBuilder<Schedule>()
                .name("scheduleReader")
                .resource(new FileSystemResource("files/data.csv"))
                .comments("Reader responsavel pela leitura do arquivo data")
                .delimited()
                .delimiter(";")
                .names("name", "phoneNumber")
                .targetType(Schedule.class)
                .build();
    }

}
