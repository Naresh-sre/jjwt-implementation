package com.juniorro.jjwtimplementation.resource;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juniorro.jjwtimplementation.entities.Task;
import com.juniorro.jjwtimplementation.service.TaskService;

@RestController
@RequestMapping(value = "/task")
public class TaskResource {

	@Autowired
	private TaskService taskService;

	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Task> listOfTask() {
		return taskService.findAll();
	}

	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Task addTask(@RequestBody Task task) {
		return taskService.saveTask(task);
	}

	@GetMapping("/{id}")
	public Task getTask(@PathVariable("id") Long id) {
		Task task = taskService.findTask(id);
		return task;
	}

	@PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Task updateTask(@RequestBody Task task) {
		return taskService.saveTask(task);
	}

}
