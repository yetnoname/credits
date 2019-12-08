package com.credits.demo.services;

import com.credits.demo.entities.User;
import com.credits.demo.repositories.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

public class UserService {

    private UserRepository userRepository;

    public User blockUser(Long id) {
        // TODO: block user by id
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setBlocked(true);
            userRepository.save(user);
        } else {
            throw new EntityNotFoundException("User with id = " + blockUser(id) + " not found");
        }
        return null;
    }
}
