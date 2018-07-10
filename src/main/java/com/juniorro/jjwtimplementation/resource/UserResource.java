package com.juniorro.jjwtimplementation.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juniorro.jjwtimplementation.entities.AppUser;
import com.juniorro.jjwtimplementation.service.AccountService;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

	@Autowired
	AccountService accountService;
	
	@PostMapping(value = "/register")
	public AppUser register(@RequestBody AppUser appUser) {
		return accountService.saveUser(appUser);
	}

}
