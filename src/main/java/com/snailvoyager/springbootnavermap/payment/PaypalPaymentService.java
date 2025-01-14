package com.snailvoyager.springbootnavermap.payment;

import org.springframework.stereotype.Service;

@Service
public class PaypalPaymentService implements PaymentService {

    @Override
    public void pay(int money) {
        System.out.println("PaypalPaymentService...");
    }
}
