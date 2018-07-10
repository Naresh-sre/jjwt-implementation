package com.juniorro.jjwtimplementation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juniorro.jjwtimplementation.entities.Task;

/*@RepositoryRestResource*/
public interface TaskRepo extends JpaRepository<Task, Long> {

}
