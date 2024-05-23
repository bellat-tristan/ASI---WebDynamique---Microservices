package com.roby.oui.SPCardGame.controller;

import com.roby.oui.SPCardGame.model.User;
import com.roby.oui.SPCardGame.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public ResponseEntity<Boolean> registerUser(@RequestBody User user) {
        Boolean createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody Map<String, String> loginDetails, HttpSession session) {
        String username = loginDetails.get("username");
        String password = loginDetails.get("password");
        User user = userService.getUserByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("username", username);
            session.setAttribute("userId", user.getId());
            session.setAttribute("credits", user.getCredits());

            // Create response body with user details
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("username", username);
            responseBody.put("userId", user.getId());
            responseBody.put("credits", user.getCredits());

            // Return user details in response body along with OK status
            return ResponseEntity.ok(responseBody);
        }

        // If login fails, return UNAUTHORIZED status
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }



    @RequestMapping(value = {"/deconnect"}, method = RequestMethod.POST)
    public ResponseEntity<Void> deconnectUser(HttpSession session) {
        // Invalidate the session or clear session attributes
        session.invalidate(); // This will invalidate the entire session

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/credits/{username}")
    public ResponseEntity<Map<String, Object>> getUserCredits(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        if (user != null) {
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("username", user.getUsername());
            responseBody.put("credits", user.getCredits());
            return ResponseEntity.ok(responseBody);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
