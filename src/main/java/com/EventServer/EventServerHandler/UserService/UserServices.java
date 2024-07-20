package com.EventServer.EventServerHandler.UserService;

import com.EventServer.EventServerHandler.Controller.LoginRequest;
import com.EventServer.EventServerHandler.UserEntity.User;
import com.EventServer.EventServerHandler.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;




    public String create_user(User user) {
        userRepository.save(user);
        return "Successfully Created";
    }

    public String login(LoginRequest request) {
        try {
            User user = findUserByEmail(request.getEmail());
            if (user == null) {
                throw new Exception("User not found with email: " + request.getEmail());
            }

            if(user.getPassword().matches(request.getPassword())){
                return  "authcaite";
            }
            else{
                return  "password not matched";
            }
        }catch (Exception e){
            return "Internal issue";
        }
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
