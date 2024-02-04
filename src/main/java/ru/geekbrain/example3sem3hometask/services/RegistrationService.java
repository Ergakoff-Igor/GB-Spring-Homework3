package ru.geekbrain.example3sem3hometask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrain.example3sem3hometask.domain.User;

@Service
public class RegistrationService {

    @Autowired
    private DataProcessingService dataProcessingService;
    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    public UserService getUserService() {
        return userService;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }


    public String processRegistration(String name, int age, String email){
        User newUser = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(newUser);
        return notificationService.sendNotification(newUser);
    }

    //Поля UserService, NotificationService

    //Метод processRegistration
}
