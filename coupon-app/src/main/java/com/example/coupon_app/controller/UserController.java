package com.example.coupon_app.controller;

import com.example.coupon_app.dto.UserRequestDto;

import com.example.coupon_app.entity.User;
import com.example.coupon_app.service.CouponService;
import com.example.coupon_app.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return this.userService.getAllUsers();
    }

    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }

    @PostMapping
    public User createUser(@Valid @RequestBody UserRequestDto requestDto){
        return userService.createUser(requestDto);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }
}
