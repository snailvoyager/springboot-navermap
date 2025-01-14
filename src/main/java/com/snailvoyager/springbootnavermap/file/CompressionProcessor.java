package com.snailvoyager.springbootnavermap.file;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(2)
public class CompressionProcessor implements FileProcessor {
    @Override
    public void process(String file) {
        System.out.println("Compression Process...");
    }
}
