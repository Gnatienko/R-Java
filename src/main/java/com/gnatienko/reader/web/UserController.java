package com.gnatienko.reader.web;

import com.gnatienko.reader.model.UserEntity;
import com.gnatienko.reader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public UserEntity save(@RequestBody UserEntity entity) {
        return service.save(entity);
    }
    @GetMapping("/{id}")
    public UserEntity getById(@PathVariable("id") Long id){
        return  service.get(id);
    }

}
