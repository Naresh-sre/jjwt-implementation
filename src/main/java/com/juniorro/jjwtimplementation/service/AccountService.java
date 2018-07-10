package com.juniorro.jjwtimplementation.service;

import com.juniorro.jjwtimplementation.entities.AppRole;
import com.juniorro.jjwtimplementation.entities.AppUser;

public interface AccountService {
	
	public AppUser saveUser(AppUser appUser);
	
	public AppRole saveRole(AppRole role);
	
	public void addRoleToUser(String username, String roleName);
	
	public AppUser findByUsername(String username);

}
