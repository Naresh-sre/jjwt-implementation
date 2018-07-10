package com.juniorro.jjwtimplementation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juniorro.jjwtimplementation.entities.AppUser;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {

	public AppUser findByUsername(String username);
}
