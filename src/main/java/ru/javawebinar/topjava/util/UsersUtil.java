package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class UsersUtil {
    public static final List<User> users = Arrays.asList(
            new User(null,"Bob", "jhon@gmail.com","12345", Role.USER),
            new User(null,"David", "david@gmail.com","12345789", Role.USER),
            new User(null,"Bob", "bob@gmail.com","qwerty", Role.USER));

}
