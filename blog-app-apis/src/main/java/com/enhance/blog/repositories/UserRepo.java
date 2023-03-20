package com.enhance.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enhance.blog.entities.User;

public interface UserRepo extends JpaRepository<User,Integer>{

}
