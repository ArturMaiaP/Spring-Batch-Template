package com.template.springbatchtemplate.job;

import com.template.springbatchtemplate.domain.Product;
import com.template.springbatchtemplate.tasks.ProductProcessor;
import com.template.springbatchtemplate.tasks.ProductReader;
import com.template.springbatchtemplate.tasks.ProductWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
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

    private final static int CHUNK_SIZE = 1;

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
        return this.stepBuilderFactory.get("step1").<Product,Product>chunk(CHUNK_SIZE)
                .reader(productItemReader())
                .processor(productItemProcessor())
                .writer(productItemWriter())
                .build();
    }

    @StepScope
    @Bean
    public ItemReader<Product> productItemReader(){
        return new ProductReader();
    }

    @StepScope
    @Bean
    public ItemProcessor<Product,Product> productItemProcessor(){
        return new ProductProcessor();
    }

    @StepScope
    @Bean
    public ItemWriter<Product> productItemWriter(){
        return new ProductWriter();
    }
}
