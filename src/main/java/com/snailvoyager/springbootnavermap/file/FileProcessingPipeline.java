package com.snailvoyager.springbootnavermap.file;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FileProcessingPipeline {

    private final List<FileProcessor> processors;

    public void execute(String file) {
        for (FileProcessor processor : processors) {
            processor.process(file);
        }
    }
}
