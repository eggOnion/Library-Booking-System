package com.example.librarybookingsystem.serviceimpls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.example.librarybookingsystem.entities.User;
import com.example.librarybookingsystem.exceptions.UserNotFoundException;
import com.example.librarybookingsystem.repositories.UserRepository;
import com.example.librarybookingsystem.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    //This is the class for CRUD Operation?

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        User newUser = userRepository.save(user);
        return newUser;
    }

    @Override
    public User getUser(int id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public ArrayList<User> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return (ArrayList<User>) allUsers;
    }

    @Override
    public User updateUser(int id, User user) {

        User userToUpdate = userRepository.findById(id).get();
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setEmail(user.getEmail());
        return userRepository.save(userToUpdate);    
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public ArrayList<User> searchUsers(String firstName) {
        List<User> findUser = userRepository.findByUser(firstName);
        return (ArrayList<User>) findUser;        
    } 
    
}
