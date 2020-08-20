package com.montstudio.segaretrogames.backend.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.montstudio.segaretrogames.backend.integration.model.User;
import com.montstudio.segaretrogames.backend.integration.repositories.UserRepository;

@RestController
public class UsersController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@RequestMapping(value="users")
	public List<User> getAll(){
		
		return userRepository.findAll();
		
	}

}
