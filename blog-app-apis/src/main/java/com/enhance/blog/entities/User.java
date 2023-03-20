package com.enhance.blog.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table( name="Users",schema="blog_app_apis")
@NoArgsConstructor
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // for auto increment id generation
	private int id;
	
	@Column(name="user_name",nullable=false,length=100) //  to define name column and attribites for it
	private String name;
	private String email;
	private String password;
	private String about;
}
