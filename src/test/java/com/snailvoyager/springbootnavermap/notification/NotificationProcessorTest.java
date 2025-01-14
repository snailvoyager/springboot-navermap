package com.snailvoyager.springbootnavermap.notification;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NotificationProcessorTest {

    @Autowired
    NotificationProcessor processor;

    @Test
    void notificationProcessing() {
        processor.notify(NotificationType.SMS, "send sms message");
        processor.notify(NotificationType.EMAIL, "send email message");
    }
}