package com.enhance.blog.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.enhance.blog.entities.User;
import com.enhance.blog.payloads.UserDto;
import com.enhance.blog.repositories.UserRepo;
import com.enhance.blog.services.UserService;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDto createUser(UserDto user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto updateUser(UserDto user, Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Integer UserId) {
		// TODO Auto-generated method stub
		
	}
	
	public User dtoToUser(UserDto userDto)
	{
		
		User user = new User();
		
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		
		return user;
		
		
		
	}
	
	public UserDto userToDto(User user)
	{
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		userDto.setAbout(user.getAbout());
		
		return userDto;
	}

}