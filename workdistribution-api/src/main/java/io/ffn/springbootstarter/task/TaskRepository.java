package io.ffn.springbootstarter.task;

import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long>{
	public Long countByAgentIdAndTaskStatus(String agentId, char status);
	public Long countByAgentIdAndPriorityAndTaskStatus(String agentId,String priority, char status);
	public Task findByAgentIdAndPriorityAndTaskStatus(String agentId, String priority, char status);
	

}
