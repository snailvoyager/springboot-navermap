package com.snailvoyager.springbootnavermap.file;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(1)
public class ValidationProcessor implements FileProcessor {
    @Override
    public void process(String file) {
        System.out.println("Validation Process...");
    }
}
