package com.example.coupon_app.service;

import com.example.coupon_app.dto.UserRequestDto;

import com.example.coupon_app.entity.User;
import com.example.coupon_app.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(UserRequestDto dto){
        User user = new User();
        user.setEmail(dto.getEmail());
        return userRepository.save(user);
    }

    public void deleteUser(Long id){ userRepository.deleteById(id);}



}
