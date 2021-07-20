package com.marcello.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.marcello.mongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {


	List<Post> findByTitleIgnoreCase(String text);
	
}
