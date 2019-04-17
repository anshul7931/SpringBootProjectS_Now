package com.anshul.src.controller;

import java.util.List;

import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Sort;

import com.anshul.src.dao.UserRepository;
import com.anshul.src.model.User;

@RestController
public class UserResource {
	
	private UserRepository userRepository;
	
	public UserResource(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@GetMapping("users")
	public List<User> getUsers(
			@RequestParam("searchParam") String searchParam,
			@RequestParam("name") String name,
			@RequestParam("order") String order,
			@RequestParam("limit") Integer limit,
			@RequestParam("offset") Integer offset
	){
		return  (List<User>) userRepository.findBySerchTerm(searchParam,name,order,limit,offset);
	}
	
	
	
}
