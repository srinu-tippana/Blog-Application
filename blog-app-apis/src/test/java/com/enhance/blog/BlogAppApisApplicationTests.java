package com.enhance.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.enhance.blog.repositories.UserRepo;

@SpringBootTest
class BlogAppApisApplicationTests {

	@Autowired
	private  UserRepo userRepo;
	@Test
	void contextLoads() {
	}
	
	
	@Test
	public void repoTest() {
		
		String name=this.userRepo.getClass().getName();
		String packname= this.userRepo.getClass().getPackageName();
		
		System.out.println(String.format("%s is the username and package name is %s",name,packname ));
	}

}
