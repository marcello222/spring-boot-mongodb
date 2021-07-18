package com.marcello.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.marcello.mongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	
	
}
