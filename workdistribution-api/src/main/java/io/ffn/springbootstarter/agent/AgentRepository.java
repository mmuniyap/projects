package io.ffn.springbootstarter.agent;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AgentRepository extends CrudRepository<Agent, String>{
	
	public List<Agent> findBySkillLevel(String SkillLevel);

}
