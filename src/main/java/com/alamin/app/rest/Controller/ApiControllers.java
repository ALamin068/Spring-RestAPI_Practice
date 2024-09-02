package com.alamin.app.rest.Controller;


import com.alamin.app.rest.Repo.UserRepo;
import com.alamin.app.rest.Models.User;
import com.alamin.app.rest.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {

    private final UserService userService;
    @Autowired
    public ApiControllers(UserService userService){
        this.userService = userService;
    }
//    @Autowired
//    private UserRepo userRepo;
    @GetMapping(value = "/")
    public String getPage(){
        return "Hi Al Amin";
    }

    @GetMapping(value ="/users")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }
    @PostMapping(value = "/save")
    public User saveUser(@RequestBody User user){
        System.out.println(user.toString());
       return userService.saveUser(user);

    }
    @PutMapping(value= "/update/{id}")
    public User updateUser(@RequestBody User user,@PathVariable long id){
        System.out.println(user.toString());
        return userService.updateUser(user,id);
    }


    //Deletion

    @DeleteMapping(value = "/delete/{id}")
    public User deleteUser(@PathVariable long id){

        return userService.deleteUser(id);

    }


}
