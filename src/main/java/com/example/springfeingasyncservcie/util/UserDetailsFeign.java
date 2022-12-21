package com.example.springfeingasyncservcie.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.springfeingasyncservcie.service.UserDetails;

@FeignClient(value = "user-details", url = "https://jsonplaceholder.typicode.com")
public interface UserDetailsFeign {
	
	@GetMapping("/posts/{id}")
	public UserDetails getUserDetails(@PathVariable int id);

}
