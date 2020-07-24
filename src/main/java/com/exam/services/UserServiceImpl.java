package com.exam.services;
import com.exam.models.User;
import com.exam.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserService UserService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List <User> findAll() {
        return UserService.findAll();
    }

    @Override
    public void saveUser(User User) {
        this.UserService.saveUser(User);
    }

    @Override
    public User getUserById(long id) {
        Optional< User > optional = Optional.ofNullable(UserService.getUserById(id));
        User User = null;
        if (optional.isPresent()) {
            User = optional.get();
        } else {
            throw new RuntimeException(" Departement not found for id :: " + id);
        }
        return User;
    }

    @Override
    public void deleteUserById(long id) {
        this.UserService.deleteUserById(id);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email,password);
    }
}
