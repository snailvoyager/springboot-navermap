package com.snailvoyager.springbootnavermap.payment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PaymentProcessorTest {

    @Autowired
    PaymentProcessor processor;

    @Test
    void processPayment_strategyPattern() {
        processor.processPayment("creditPaymentService", 500);
        processor.processPayment("paypalPaymentService", 1000);
    }

}