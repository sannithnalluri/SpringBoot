package com.EventServer.EventServerHandler.Controller;

import com.EventServer.EventServerHandler.UserEntity.User;
import com.EventServer.EventServerHandler.UserService.UserServices;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RestController
@RequestMapping("/user")
public class UserAPI {
    @Autowired
    private UserServices userServices;
    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return  ResponseEntity.ok("<h1>Hello Welcome To Event<h1>");
    }

    @PostMapping("/register")
    public  ResponseEntity<String> register_User(@RequestBody User user){
        try{
        String res = userServices.create_user(user);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
        catch(Exception e){
        return new ResponseEntity<>("some issue occured",HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public  ResponseEntity<String> authicate(@RequestBody LoginRequest loginRequest){

        try {
            String res = userServices.login(loginRequest);
            return ResponseEntity.ok("aunticate");
        }
        catch (Exception e){
            return new ResponseEntity<>("Login failed",HttpStatus.NOT_FOUND);
        }
    }
}
