package com.example.users.service;

import com.example.users.dto.LoginDTO;
import com.example.users.entity.User;
import com.example.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    //get all the users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //Create new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    //Get user by ID
    public User getUserById(int id) {
        Optional<User> user1 = userRepository.findById(id);
        if (user1.isPresent()) {
            return user1.get();
        }
        return null;
    }

    //Delete user by ID
    public void deleteUserById(int id) {
        userRepository.deleteById(id);

    }
    // Method for handling password update by email
    public User updateUserPasswordByEmail(String email, User user) {
        // Search for the user by email using the repository method
        List<User> users = userRepository.searchUserByEmail(email);

        // Check if the user exists
        if (!users.isEmpty()) {
            User foundUser = users.get(0);  // Assuming the email is unique, we take the first match
            foundUser.setPassword(user.getPassword());  // Update the password with the new one

            // Save the updated user to the database
            return userRepository.save(foundUser);
        } else {
            // Handle case where no user is found with the provided email
            return user;
        }
    }

    //Fully update the user by id
    public User updateUser(int id, User user) {
        Optional<User> user1 = userRepository.findById(id);

        if (user1.isPresent()) {
            User existingUser = user1.get();
            existingUser.setName(user.getName());
            existingUser.setAddress(user.getAddress());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setRole(user.getRole());
            userRepository.save(existingUser);
            return existingUser;
        }
        return user;
    }

    //Search user by name and email
    public  List<User> searchUserByNameEmail(String name, String email){
        return userRepository.searchUserByNameEmail(name , email);
    }

    //Search user by name
    public List<User> searchUserByName(String name){
        return userRepository.searchUserByName(name);
    }

    //Search user by email
    public List<User> searchUserByEmail(String email){
        return userRepository.searchUserByEmail(email);

    }


    //Validate user enters login details with actual login details
    public User validateUser(LoginDTO loginDTO) {
        List<User> users = userRepository.searchUserByEmail(loginDTO.getEmail());

        if (users.isEmpty()) {
            return null;
        }
        User user = users.get(0);
        return user.getPassword().equals(loginDTO.getPassword()) ? user : null;
    }

}
