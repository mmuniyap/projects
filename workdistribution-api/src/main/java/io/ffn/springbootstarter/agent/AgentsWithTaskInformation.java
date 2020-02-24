package io.ffn.springbootstarter.agent;


public class AgentsWithTaskInformation {
	
	private String id;
	private String skillLevel;
	private Long currentlyAssignedHighPriorityTask;
	private Long currentlyAssignedLowPriorityTask;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSkillLevel() {
		return skillLevel;
	}
	public void setSkillLevel(String skillLevel) {
		this.skillLevel = skillLevel;
	}
	public long getCurrentlyAssignedHighPriorityTask() {
		return currentlyAssignedHighPriorityTask;
	}
	public AgentsWithTaskInformation() {
		
	}
	public AgentsWithTaskInformation(String id, String skillLevel, Long currentlyAssignedHighPriorityTask,
			Long currentlyAssignedLowPriorityTask) {
		super();
		this.id = id;
		this.skillLevel = skillLevel;
		this.currentlyAssignedHighPriorityTask = currentlyAssignedHighPriorityTask;
		this.currentlyAssignedLowPriorityTask = currentlyAssignedLowPriorityTask;
	}
	public void setCurrentlyAssignedHighPriorityTask(long currentlyAssignedHighPriorityTask) {
		this.currentlyAssignedHighPriorityTask = currentlyAssignedHighPriorityTask;
	}
	public long getCurrentlyAssignedLowPriorityTask() {
		return currentlyAssignedLowPriorityTask;
	}
	public void setCurrentlyAssignedLowPriorityTask(long currentlyAssignedLowPriorityTask) {
		this.currentlyAssignedLowPriorityTask = currentlyAssignedLowPriorityTask;
	}
	
	
	
}
