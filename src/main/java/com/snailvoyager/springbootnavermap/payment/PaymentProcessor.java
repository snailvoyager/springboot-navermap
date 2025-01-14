package com.snailvoyager.springbootnavermap.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class PaymentProcessor {

    private final Map<String, PaymentService> paymentServices;

    public void processPayment(String paymentType, int amount) {
        PaymentService paymentService = paymentServices.get(paymentType);

        if (paymentService != null) {
            paymentService.pay(amount);
        }
    }
}
