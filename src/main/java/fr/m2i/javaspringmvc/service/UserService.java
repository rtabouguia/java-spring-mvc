/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.javaspringmvc.service;

import fr.m2i.javaspringmvc.model.User;
import fr.m2i.javaspringmvc.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RAISA
 */
@Service
public class UserService {
    
       private final UserRepository repo;

    @Autowired
    public UserService(UserRepository repo) {
        this.repo = repo;
    }
    
    public Double getBalance() throws Exception {
        // Code avec lambda
        User userFounded = repo.findById(1L).orElseThrow(() -> new Exception()); // Todo throw a custom exception called NotFoundException

//        // Code sans lambda
//        Optional<User> userOptional = repo.findById(1L);
//        User userFounded;
//
//        if (!userOptional.isPresent()) {
//            throw new Exception();
//        }

//        userFounded = userOptional.get();
        
        return userFounded.getBalance();
    }
    
     public void addBalance(Double balance) throws Exception {
        // Code avec lambda
        User userFounded = repo.findById(1L).orElseThrow(() -> new Exception()); // Todo throw a custom exception called NotFoundException
        userFounded.setBalance(userFounded.getBalance() + balance);
        repo.save(userFounded);
    }
     
     
     public void decreaseBalance(Double balance) throws Exception {
        User user = repo.findById(1L).orElseThrow(() -> new Exception()); // Todo throw a custom exception called NotFoundException
        user.setBalance(user.getBalance() - balance);

        repo.save(user);
    }
}
