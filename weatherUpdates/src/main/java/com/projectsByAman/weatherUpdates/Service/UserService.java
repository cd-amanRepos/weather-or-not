package com.projectsByAman.weatherUpdates.Service;

import com.projectsByAman.weatherUpdates.Entity.User;
import com.projectsByAman.weatherUpdates.Exception.InputNotFoundException;
import com.projectsByAman.weatherUpdates.Exception.UserNameAlreadyExistsException;
import com.projectsByAman.weatherUpdates.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BucketService bucketService;
    public User getUser(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isEmpty()) throw new InputNotFoundException();
        return user.get();
    }

    public User addUser(User user) {
        Optional<User> checkUser = userRepository.findByUsername(user.getUsername());
        if(checkUser.isPresent()) throw new UserNameAlreadyExistsException();
        user.setBucket(bucketService.createDashboard());
        return userRepository.save(user);
    }

    public void deleteUser(String username) {
        User user = userRepository.findByUsername(username).get();
        userRepository.delete(user);
    }

    public User addUser(String name, String username) {
        Optional<User> checkUser = userRepository.findByUsername(username);
        if(checkUser.isPresent()) throw new UserNameAlreadyExistsException();
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setName(name);
        return userRepository.save(newUser);
    }
}
