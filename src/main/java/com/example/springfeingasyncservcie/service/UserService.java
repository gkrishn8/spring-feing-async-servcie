package com.example.springfeingasyncservcie.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.springfeingasyncservcie.util.UserDetailsFeign;

@Service
public class UserService {

	@Autowired
	UserDetailsFeign userDetailsFeign;

	@Async("asyncExecutor")
	public CompletableFuture<UserDetails> getUserinfo(int id) throws InterruptedException {
		System.out.println("Thread name : " + Thread.currentThread().getName() + " request id  : " + id);
		UserDetails userDetails = userDetailsFeign.getUserDetails(id);
		return CompletableFuture.completedFuture(userDetails);
	}

}
