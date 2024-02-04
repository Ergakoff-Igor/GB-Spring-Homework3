package ru.geekbrain.example3sem3hometask.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;
import ru.geekbrain.example3sem3hometask.domain.User;
import ru.geekbrain.example3sem3hometask.repository.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Getter
@AllArgsConstructor
public class DataProcessingService {

    private UserRepository repository;


    public List<User> sortUsersByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    public List<User> filterUsersByAge(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    public double calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

    public void  addUserToList(User user)
    {
        repository.getUsers().add(user);
    }
}
