package com.enhance.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enhance.blog.entities.Category;
import com.enhance.blog.entities.Post;
import com.enhance.blog.entities.User;

public interface PostRepo extends JpaRepository<Post,Integer> {
	
	List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
}
