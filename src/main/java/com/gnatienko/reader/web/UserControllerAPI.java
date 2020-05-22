package com.gnatienko.reader.web;

import com.gnatienko.reader.model.BookContentEntity;
import com.gnatienko.reader.model.UserEntity;
import com.gnatienko.reader.model.Word;
import com.gnatienko.reader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")//localhost:3000~*
@RestController
@RequestMapping("/api/users")
public class UserControllerAPI {

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<UserEntity> postUserEntity(@RequestBody UserEntity userEntity){
        userService.save(userEntity);
        return ResponseEntity.ok(userEntity);
    }

    @GetMapping
    public   ResponseEntity<UserEntity> getUserEntity() {
        //System.out.println(userService.get(1L));
        return ResponseEntity.ok(userService.get(1L));
    }

    @DeleteMapping (value ="/{id}")
    public   ResponseEntity<String> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.delete(id));

    }

}
