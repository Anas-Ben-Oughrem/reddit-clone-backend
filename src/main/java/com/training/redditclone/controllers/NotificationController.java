package com.training.redditclone.controllers;

import com.training.redditclone.entities.Notification;
import com.training.redditclone.services.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/Notifications")
@AllArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

    @GetMapping
    public List<Notification> getAllNotifications(){
        return notificationService.getAllNotifications();
    }

    @GetMapping("/{id}")
    public Notification getNotification(@PathVariable Long id){
        return  notificationService.getNotification(id);
    }
}
