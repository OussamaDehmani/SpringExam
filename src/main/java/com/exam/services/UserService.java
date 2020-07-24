package com.exam.services;
import com.exam.models.User;

import java.util.List;


public interface UserService {


    void saveUser(User User);
    User getUserById(long id);
    void deleteUserById(long id);
    User findByEmailAndPassword(String email,String password);
    List<User> findAll();
}
