package com.juniorro.jjwtimplementation.service.implementation;

import java.util.Collection;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juniorro.jjwtimplementation.entities.Task;
import com.juniorro.jjwtimplementation.repo.TaskRepo;
import com.juniorro.jjwtimplementation.service.TaskService;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepo taskRepo;
	
	@Override
	public Collection<Task> findAll() {
		return taskRepo.findAll();
	}

	@Override
	public Task saveTask(Task task) {
		return taskRepo.save(task);
	}

	@Override
	public Task findTask(Long id) {
		return null; //taskRepo.findOne(id);
	}

}
