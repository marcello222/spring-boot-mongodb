package com.marcello.mongodb.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.marcello.mongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {


	@Query("{ 'title': { $regex: ?0, /pattern/, $options: 'i'}}")
	List<Post> searchTitle(String text);
	
	
	List<Post> findByTitleIgnoreCase(String text);
	
	@Query("{ $and: [{field: {$gte: ?1} }, {date:{ $lte: ?2} }, { $or: [{ 'title': { $regex: ?0, /pattern/, $options: 'i'} }, { 'body': { $regex: ?0, /pattern/, $options: 'i'}}, { 'comments.text': { $regex: ?0, /pattern/, $options: 'i'} } ] } ] } ")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
	
}
