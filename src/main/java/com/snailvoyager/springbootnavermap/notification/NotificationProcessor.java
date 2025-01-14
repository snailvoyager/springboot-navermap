package com.snailvoyager.springbootnavermap.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class NotificationProcessor {

    private final Map<String, NotificationService> serviceMap;

    public void notify(NotificationType type, String message) {
        NotificationService service = serviceMap.get(type.getQualifier());
        if (service != null) {
            service.send(message);
        }
    }
}
