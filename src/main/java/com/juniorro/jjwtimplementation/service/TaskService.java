package com.juniorro.jjwtimplementation.service;

import java.util.Collection;

import com.juniorro.jjwtimplementation.entities.Task;

public interface TaskService {
	
	public Task saveTask(Task task);
	
	public Collection<Task> findAll();

	public Task findTask(Long id);

}
