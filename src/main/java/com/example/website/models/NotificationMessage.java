package com.example.website.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotificationMessage {
    NotificationMessageType type;
    String text;
}
