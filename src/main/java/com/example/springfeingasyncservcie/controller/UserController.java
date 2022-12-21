package com.example.springfeingasyncservcie.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springfeingasyncservcie.service.UserDetails;
import com.example.springfeingasyncservcie.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserService userService;

	
	@GetMapping("/user-info")
	public List<UserDetails> getUserDetails() throws InterruptedException, ExecutionException {
		
		List<CompletableFuture<UserDetails>> userFutureList = new ArrayList<>();
		
		for (int i = 1; i <= 5; i++) {
			CompletableFuture<UserDetails>  userDetails = userService.getUserinfo(i);
			userFutureList.add(userDetails);
		}
		List<UserDetails> userList = new ArrayList<>();
		for(CompletableFuture<UserDetails> user : userFutureList) {
			userList.add(user.get());
		}
		return userList;
	}

}
