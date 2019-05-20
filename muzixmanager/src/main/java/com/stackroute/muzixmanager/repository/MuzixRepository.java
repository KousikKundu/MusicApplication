package com.stackroute.muzixmanager.repository;

import com.stackroute.muzixmanager.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface  MuzixRepository extends MongoRepository<User, String> {

    public User findByUserName(String userName);
}
