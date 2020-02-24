package io.ffn.springbootstarter.agent;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ffn.springbootstarter.task.Task;
import io.ffn.springbootstarter.task.TaskRepository;

@Service
public class AgentService {
	
	private static final String HIGH_PRIORITY="high";
	private static final String LOW_PRIORITY="low";
	private static final char TASK_ASSIGNED_TO_AGENT = 'a';
	
	@Autowired
	private TaskRepository taskRepository;
	
	private List<Agent> agents = new ArrayList<Agent> (Arrays.asList(
			new Agent("Agent1", "skill1, skill2, skill3"),
			new Agent("Agent2", "skill1, skill2, skill3"),
			new Agent("Agent3", "skill1"),
			new Agent("Agent4", "skill2"),
			new Agent("Agent5", "skill3"))
			);
	
	Exception noFreeAgentAvailable = new Exception("No Free Agent Found");
	
	public List<Agent> getAllAgents(){
		return agents;
	}
	
	public List<AgentsWithTaskInformation> getAllAgentsWithTaskInfo(){
		List<AgentsWithTaskInformation> agentsWTI = new ArrayList<AgentsWithTaskInformation>();
		
		for(int i=0; i<agents.size(); i++) {
			Agent a = agents.get(i);
			Task highPriTask = null;
			if(taskRepository.countByAgentIdAndPriorityAndTaskStatus(a.getId(), HIGH_PRIORITY,TASK_ASSIGNED_TO_AGENT)==1) 
				highPriTask=taskRepository.findByAgentIdAndPriorityAndTaskStatus(a.getId(), HIGH_PRIORITY, TASK_ASSIGNED_TO_AGENT);
			
			Task lowPriorityTask = null;
			if(taskRepository.countByAgentIdAndPriorityAndTaskStatus(a.getId(), LOW_PRIORITY,TASK_ASSIGNED_TO_AGENT)==1)
				lowPriorityTask= taskRepository.findByAgentIdAndPriorityAndTaskStatus(a.getId(), LOW_PRIORITY, TASK_ASSIGNED_TO_AGENT);
			
			if(!(highPriTask==null)&&!(lowPriorityTask==null))
				agentsWTI.add(new AgentsWithTaskInformation(a.getId(), a.getSkillLevel(), highPriTask.getId(), lowPriorityTask.getId()));
			else if(!(highPriTask==null)&&(lowPriorityTask==null))
				agentsWTI.add(new AgentsWithTaskInformation(a.getId(), a.getSkillLevel(), highPriTask.getId(), 0l));
			else if((highPriTask==null)&&!(lowPriorityTask==null))
				agentsWTI.add(new AgentsWithTaskInformation(a.getId(), a.getSkillLevel(), 0l, lowPriorityTask.getId()));
			else
				agentsWTI.add(new AgentsWithTaskInformation(a.getId(), a.getSkillLevel(), 0l, 0l));
		}
		return agentsWTI;
	}
	
	public Agent findAgentBySkills(String skills, String taskPriority) {
		List<Agent> matchingSkillAgents = agents.stream().filter(a -> a.getSkillLevel().contains(skills)
						||a.getSkillLevel().equals(skills)).collect(Collectors.toList());
		for(int i=0; i<matchingSkillAgents.size(); i++) {
			Agent a = matchingSkillAgents.get(i);
			if(taskRepository.countByAgentIdAndPriorityAndTaskStatus(a.getId(),taskPriority, TASK_ASSIGNED_TO_AGENT)==0 
					&&
				taskRepository.countByAgentIdAndTaskStatus(a.getId(), TASK_ASSIGNED_TO_AGENT)==0)
				return a;
		}
		for(int i=0; i<matchingSkillAgents.size(); i++) {
			Agent a = matchingSkillAgents.get(i);
			if(taskPriority.equals(HIGH_PRIORITY)) {
				if(taskRepository.countByAgentIdAndPriorityAndTaskStatus
						(a.getId(),taskPriority, TASK_ASSIGNED_TO_AGENT)==0)
					return a;
			}
			
		}
		return null;
	}
	
	public Agent getAgent(String Id) {
			return agents.stream().filter(a -> a.getId().equals(Id)).findFirst().get();
	}
}
