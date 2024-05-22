package com.roby.oui.SPCardGame.controller;

import com.roby.oui.SPCardGame.model.User;
import com.roby.oui.SPCardGame.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public ResponseEntity<Boolean> registerUser(User user) {
        Boolean createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public ResponseEntity<Void> loginUser(Map<String, String> loginDetails, HttpSession session) {
        String username = loginDetails.get("username");
        String password = loginDetails.get("password");
        User user = userService.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("username", username);
            session.setAttribute("userId", user.getId());
            session.setAttribute("credits", user.getCredits());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
