package org.example;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfig {
    private final FooTasklet fooTasklet;

    @Autowired
    public BatchConfig(FooTasklet fooTasklet) {
        this.fooTasklet = fooTasklet;
    }

    @Bean
    public Job job(JobRepository jobRepository, PlatformTransactionManager transactionManager) throws Exception {
        var step = new StepBuilder("fooStep", jobRepository).tasklet(fooTasklet, transactionManager).build();
        return new JobBuilder("fooJob", jobRepository).start(step).build();
    }
}
