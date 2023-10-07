package com.springBatch.schedule.writer;

import com.springBatch.schedule.constants.Constants;
import com.springBatch.schedule.entity.Schedule;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ScheduleWriterConfig {

    @Bean
    public ItemWriter<Schedule> itemWriter(DataSource dataSource){
        return new JdbcBatchItemWriterBuilder<Schedule>()
                .dataSource(dataSource)
                .sql(Constants.SQL_INSERT_CONTACT)
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .build();
    }

}
