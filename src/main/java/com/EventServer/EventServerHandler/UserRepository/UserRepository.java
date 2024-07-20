package com.EventServer.EventServerHandler.UserRepository;

import com.EventServer.EventServerHandler.UserEntity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
    User findByEmail(String email);
}
