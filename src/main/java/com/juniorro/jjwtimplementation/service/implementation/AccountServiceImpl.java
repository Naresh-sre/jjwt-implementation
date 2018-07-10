package com.juniorro.jjwtimplementation.service.implementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.juniorro.jjwtimplementation.entities.AppRole;
import com.juniorro.jjwtimplementation.entities.AppUser;
import com.juniorro.jjwtimplementation.repo.AppUserRepo;
import com.juniorro.jjwtimplementation.repo.RoleRepo;
import com.juniorro.jjwtimplementation.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private AppUserRepo appUserRepo;

	@Autowired
	private RoleRepo roleRepo;

	@Override
	public AppUser saveUser(AppUser appUser) {
		String encryptedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
		appUser.setPassword(encryptedPassword);
		return appUserRepo.save(appUser);
	}

	@Override
	public AppRole saveRole(AppRole role) {
		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		AppRole role = roleRepo.findByRoleName(roleName);
		AppUser appUser = appUserRepo.findByUsername(username);
		appUser.getRoles().add(role);

	}

	@Override
	public AppUser findByUsername(String username) {
		return appUserRepo.findByUsername(username);
	}

}
