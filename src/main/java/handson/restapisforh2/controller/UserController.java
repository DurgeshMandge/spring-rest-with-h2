package handson.restapisforh2.controller;

import handson.restapisforh2.entity.UserTable;
import handson.restapisforh2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<String> addUserToH2(@RequestBody UserTable user){
        try{
            userService.addUserToDb(user);
            return new ResponseEntity<>("added", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("server error",HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/editById/{id}")
    public ResponseEntity<String> updateUserById(@PathVariable int id, @RequestBody UserTable user){
        try{
            UserTable newUser = user;
            userService.updateUserById(id, newUser);
            return new ResponseEntity<>("Done",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("server error",HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<Optional<UserTable>> getUser(@PathVariable int id){
        try{
            Optional<UserTable> user = userService.getUserById(id);
            return new ResponseEntity<>(user,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/getAllUsers")
    private ResponseEntity<List<UserTable>> getAllUsers(){
        List<UserTable> userList = userService.getAllUsers();
        return new ResponseEntity<>(userList,HttpStatus.OK);
    }

}
//docker tag local-image:tagname new-repo:tagname
//docker push durgeshmandge/spring-rest-services:tagname