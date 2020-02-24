package io.ffn.springbootstarter.agent;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Agent {
	public enum AgentAssignmentStatus {
		AGENT_NOT_ASSIGNED, AGENT_ASSIGNED;
	}
	@Id
	private String id;
	private String skillLevel;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public Agent(String id, String skillLevel) {
		super();
		this.id = id;
		this.skillLevel = skillLevel;
	}
	public String getSkillLevel() {
		return skillLevel;
	}
	public void setSkillLevel(String skillLevel) {
		this.skillLevel = skillLevel;
	}
	public Agent() {
		
	}
	
}
