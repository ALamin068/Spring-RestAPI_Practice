package com.alamin.app.rest.Service;

import com.alamin.app.rest.Models.User;
import com.alamin.app.rest.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;
    @Autowired
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers(){

        return userRepo.findAll();

    }



    public User saveUser(User user){

        return userRepo.save(user);
    }


    public User updateUser(User user, long id){
        User updatedUser = userRepo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"User Not Found !"));
        if(user.getFirstName()!=null){
            updatedUser.setFirstName(user.getFirstName());
        }
        if(user.getLastName()!=null){
            updatedUser.setLastName(user.getLastName());
        }
        if(user.getAge()!=0){
            updatedUser.setAge(user.getAge());
        }
        if(user.getOccupation()!=null){
            updatedUser.setOccupation(user.getOccupation());
        }

        return userRepo.saveAndFlush(updatedUser);
    }

    public User deleteUser(long id){
        User deleteUser = userRepo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"User Not Found !"));
        userRepo.deleteById(id);
        return deleteUser;
    }



}
