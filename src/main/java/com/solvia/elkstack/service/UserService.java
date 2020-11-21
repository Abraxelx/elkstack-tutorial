package com.solvia.elkstack.service;

import com.solvia.elkstack.model.User;

import java.util.List;

public interface UserService {
    User getUserById(int id);
    List<User> getUsers();
}
