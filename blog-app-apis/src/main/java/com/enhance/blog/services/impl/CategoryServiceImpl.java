package com.enhance.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enhance.blog.entities.Category;
import com.enhance.blog.exceptions.ResourceNotFoundException;
import com.enhance.blog.payloads.CategoryDto;
import com.enhance.blog.repositories.CategoryRepo;
import com.enhance.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		
		Category cat = this.modelMapper.map(categoryDto,Category.class);
		Category addedCategory=this.categoryRepo.save(cat);
		
		
		return this.modelMapper.map(addedCategory,CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId) {
		// TODO Auto-generated method stub
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","CategoryId",categoryId));
		
        cat.setCategoryTitle(categoryDto.getCategoryTitle());
        cat.setCategoryDescription(categoryDto.getCategoryDescription());
        
        Category updatedCategory=this.categoryRepo.save(cat);
		
		return this.modelMapper.map(updatedCategory,CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","CategoryId",categoryId));
		
		this.categoryRepo.delete(cat);
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","CategoryId",categoryId));
		
		return this.modelMapper.map(cat,CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		// TODO Auto-generated method stub
		
		List<Category> categoryList = this.categoryRepo.findAll();
		
		List<CategoryDto> categoryDtoList=categoryList.stream()
				.map(category->this.modelMapper.map(category, CategoryDto.class))
				.collect(Collectors.toList());
		
		return categoryDtoList;
	}
	
	
	public CategoryDto categoryToDTO (Category category) {
		return this.modelMapper.map(category,CategoryDto.class);
		
	}
	
	public Category dtoToCategory(CategoryDto categoryDto) {
		
		return this.modelMapper.map(categoryDto,Category.class);
	}

}
