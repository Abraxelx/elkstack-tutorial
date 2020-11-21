package com.solvia.elkstack.service;

import com.solvia.elkstack.exception.UserNotFoundException;
import com.solvia.elkstack.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User getUserById(int id) {
        List<User> users = getUsers();
        User user = users.stream()
                .filter(u -> u.getId() == id).findAny().orElse(null);
        if (user != null) {
            logger.info("user found : {}", user);
            return user;
        } else {
            try {
                throw new UserNotFoundException("User not found");
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("User not found with ID : {}", id);
            }
            return new User();
        }
    }

    @Override
    public List<User> getUsers() {
        return Stream.of(new User(1, "Halil"),
                new User(2, "Sahin")).collect(Collectors.toList());
    }
}