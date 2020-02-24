package io.ffn.springbootstarter.task;


import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Task {
	@Id
	private Long id;
	private char agentAssigned;
	private String agentId;
	private String priority;
	private String skills;
	private char taskStatus;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public char getAgentAssigned() {
		return agentAssigned;
	}
	public void setAgentAssigned(char agentAssigned) {
		this.agentAssigned = agentAssigned;
	}
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public char getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(char taskStatus) {
		this.taskStatus = taskStatus;
	}
	public Task(Long id, char agentAssigned, String agentId, String priority, String skills,char taskStatus) {
		super();
		this.id = id;
		this.agentAssigned = agentAssigned;
		this.agentId = agentId;
		this.priority = priority;
		this.skills = skills;
		this.taskStatus = taskStatus;
	}
	
	public Task() {
		
	}
	

}
