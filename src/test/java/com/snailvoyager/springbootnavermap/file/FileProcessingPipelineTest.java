package com.snailvoyager.springbootnavermap.file;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FileProcessingPipelineTest {

    @Autowired
    FileProcessingPipeline pipeline;

    @Test
    void execute() {
        pipeline.execute("test.txt");
    }
}