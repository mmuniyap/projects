package io.ffn.springbootstarter.task;

public enum TaskStatus {
	INITIATED('i'), AGENT_ASSIGNED('a'), COMPLETED('c');

	private char statusValue;
	
	private TaskStatus (char statusValue) {
		this.statusValue=statusValue;
	}

}
