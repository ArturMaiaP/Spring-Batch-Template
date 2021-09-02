package com.template.springbatchtemplate.job;

import com.template.springbatchtemplate.domain.Product;
import com.template.springbatchtemplate.tasks.ProductReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class JobConfiguration extends DefaultBatchConfigurer {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    private final static int CHUNK_SIZE = 10;

    @Override
    public void setDataSource(DataSource dataSource){
        //Make the spring batch ignores any datasource
    }

    @Bean //If completed then stop, if failed then try again (until complete)
    public Job transitionJobs(){
        return this.jobBuilderFactory.get("ProductJob")
                .start(increasePrice10Percent())
                .build();
    }

    @Bean
    public Step increasePrice10Percent() {
        return null;
    }

    @StepScope
    @Bean
    public ItemReader<Product> productItemReader(){
        return new ProductReader();
    }

}
