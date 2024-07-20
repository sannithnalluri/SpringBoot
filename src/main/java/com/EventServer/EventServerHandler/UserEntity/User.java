package com.EventServer.EventServerHandler.UserEntity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@NoArgsConstructor
public class User {
    private String id;
    private String username;
    private String email;
    private  String password;
}
