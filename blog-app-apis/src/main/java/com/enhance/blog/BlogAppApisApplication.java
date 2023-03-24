package com.enhance.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.enhance.blog.*")
public class BlogAppApisApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApisApplication.class, args);
	}

}
