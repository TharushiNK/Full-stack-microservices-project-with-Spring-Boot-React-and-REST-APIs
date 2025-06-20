package com.example.test_twenty.service;

import com.example.test_twenty.dto.LoginDTO;
import com.example.test_twenty.entity.User;
import com.example.test_twenty.repository.UserRepository;
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
    public boolean validateUser(LoginDTO loginDTO) {
        // search for the existing users by email came from the input field
        List<User> users = userRepository.searchUserByEmail(loginDTO.getEmail());

        // if no user is found with that email, return false
        if (users.isEmpty()) {
            return false;
        }
        User user = users.get(0);//access the password from the element in 0 index
        return user.getPassword().equals(loginDTO.getPassword()); // Return true if password match else return false
    }

}