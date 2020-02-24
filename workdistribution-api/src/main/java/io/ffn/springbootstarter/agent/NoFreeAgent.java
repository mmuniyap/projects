package io.ffn.springbootstarter.agent;

public class NoFreeAgent extends RuntimeException{
	
	public NoFreeAgent() {
		super("No agent is currently free");
	}

}
