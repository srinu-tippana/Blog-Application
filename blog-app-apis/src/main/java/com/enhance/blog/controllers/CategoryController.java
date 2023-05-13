package com.enhance.blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enhance.blog.payloads.ApiResponse;
import com.enhance.blog.payloads.CategoryDto;
import com.enhance.blog.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	//create
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
		  
		CategoryDto categoryCreated=this.categoryService.createCategory(categoryDto);
		
	    return new ResponseEntity<CategoryDto>(categoryCreated,HttpStatus.CREATED);
		
	   
		
	}
	
	//update 
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer categoryId){
		CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto, categoryId);
		
		return  ResponseEntity.ok(updatedCategory);
	}
	
	
	//delete
	
	@DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId) {
		 this.categoryService.deleteCategory(categoryId);
		 
		 return new ResponseEntity<ApiResponse>(new ApiResponse("Category Deleted Successfully",true),HttpStatus.OK);
	}
	
	
	
	
	//get
	
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer categoryId){
		return ResponseEntity.ok(this.categoryService.getCategory(categoryId));
	}
	
	//get all
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategories(){
		
		
		
	   return ResponseEntity.ok(this.categoryService.getAllCategories());
		
	}

}
