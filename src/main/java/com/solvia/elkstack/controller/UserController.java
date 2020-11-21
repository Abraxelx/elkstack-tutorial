package com.solvia.elkstack.controller;

import com.solvia.elkstack.model.User;
import com.solvia.elkstack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getUser/{id}")
    @ResponseBody
    public User getUserById(@PathVariable int id){
       return userService.getUserById(id);
    }

}
