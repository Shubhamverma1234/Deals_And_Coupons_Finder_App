package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.cg.model.Users;

public interface UserRepositiory extends MongoRepository<Users, String> {
	Users findByuserName(String userName);
}
