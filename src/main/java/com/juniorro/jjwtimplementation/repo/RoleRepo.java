package com.juniorro.jjwtimplementation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juniorro.jjwtimplementation.entities.AppRole;

public interface RoleRepo extends JpaRepository<AppRole, Long> {

	public AppRole findByRoleName(String name);

}
