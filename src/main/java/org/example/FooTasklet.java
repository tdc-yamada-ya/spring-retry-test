package org.example;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FooTasklet implements Tasklet {
    private final Bar bar;

    @Autowired
    public FooTasklet(Bar bar) {
        this.bar = bar;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        bar.bar();
        return RepeatStatus.FINISHED;
    }
}
