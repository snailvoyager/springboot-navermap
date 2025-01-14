package com.snailvoyager.springbootnavermap.payment;

import org.springframework.stereotype.Service;

@Service
public class CreditPaymentService implements PaymentService {

    @Override
    public void pay(int money) {
        System.out.println("CreditPaymentService...");
    }
}
