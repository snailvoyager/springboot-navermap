package com.snailvoyager.springbootnavermap.notification;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum NotificationType {
    SMS("smsNotificationService"),
    EMAIL("emailNotificationService");

    private final String qualifier;
}
