package com.enhance.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enhance.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
	
	

}
