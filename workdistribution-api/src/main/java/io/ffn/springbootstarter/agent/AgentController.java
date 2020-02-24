package io.ffn.springbootstarter.agent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgentController {
	
	@Autowired
	private AgentService agentService;
	@RequestMapping("/agents")
	public List<AgentsWithTaskInformation> getAllAgents(){
		return agentService.getAllAgentsWithTaskInfo();
	}

}
