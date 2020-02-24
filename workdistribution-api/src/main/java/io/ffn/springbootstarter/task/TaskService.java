package io.ffn.springbootstarter.task;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ffn.springbootstarter.agent.Agent;
import io.ffn.springbootstarter.agent.AgentService;

@Service
public class TaskService {
	
	static final char AGENT_NOT_ASSIGNED='n';
	static final char AGENT_ASSIGNED='y';
	static final char TASK_INTIATED='i';
	static final char TASK_ASSIGNED_TO_AGENT = 'A';
	static final char TASK_COMPLETED = 'C';
	
	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private AgentService agentService;
	
	public List<Task> getAllTasks(){
		List<Task> tasks = new ArrayList<>();
		taskRepository.findAll().forEach(tasks::add);
		return tasks;
	}
	
	public Optional<Task> getTask(Long id) {
		return taskRepository.findById(id);
	}
	
	public boolean addTask(Task task) {
		
		//Generate Unique Task Id based on current timestamp
		Date today = new Date();
		Timestamp curTS = new Timestamp(today.getTime());
		long generatedId=curTS.getTime();
		
		task.setId(generatedId);
		task.setAgentAssigned(AGENT_NOT_ASSIGNED);
		
		Agent assignAgent = agentService.findAgentBySkills(task.getSkills(), task.getPriority());
		
		if(assignAgent==null) {
			return false;
		}
		else {
			task.setAgentId(assignAgent.getId());
			task.setAgentAssigned(AGENT_ASSIGNED);
			task.setTaskStatus(TASK_ASSIGNED_TO_AGENT);
			taskRepository.save(task);
			return true;
		}
	}
	
	public void updateTask(Task task) {
		System.out.println(task.getAgentId());
		task.setTaskStatus(TASK_COMPLETED);
		taskRepository.save(task);
	}
	
	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}
	
}
