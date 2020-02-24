package io.ffn.springbootstarter.task;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.ffn.springbootstarter.agent.NoFreeAgent;

@RestController
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	@RequestMapping("/tasks")
	public List<Task> getAllTasks(){
		return taskService.getAllTasks();
		
	}
	@RequestMapping(method=RequestMethod.POST, value="/tasks")
	public void addTask(@RequestBody Task task) {
		boolean assignTask =taskService.addTask(task);
		if(!assignTask)
			throw new NoFreeAgent();
	}
	@RequestMapping(value="/tasks/{id}")
	public Optional<Task> getTask(@PathVariable Long id) { 
		System.out.println("In get task: "+id);
		return taskService.getTask(id);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/tasks/{id}")
	public void udpateTask(@RequestBody Task task, @PathVariable Long id) {
		System.out.println("In udpate task");
		System.out.println("Task ID: "+id);
		taskService.updateTask(task);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/tasks/{id}")
	public void deleteTask(@PathVariable Long id) {
		taskService.deleteTask(id);
	}

}