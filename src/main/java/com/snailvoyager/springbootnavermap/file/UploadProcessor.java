package com.snailvoyager.springbootnavermap.file;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(3)
public class UploadProcessor implements FileProcessor {
    @Override
    public void process(String file) {
        System.out.println("Upload Process...");
    }
}
