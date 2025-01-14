package com.snailvoyager.springbootnavermap.notification;

import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Email Notification...");
    }
}
