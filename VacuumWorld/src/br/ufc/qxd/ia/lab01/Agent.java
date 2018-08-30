package br.ufc.qxd.ia.lab01;

import java.util.List;

public abstract class Agent {
	
	private Perception peception;
	private List<Action> actions;
	
	public Agent(Perception perception, List<Action> actions) {
		super();
		this.peception = perception;
		this.actions = actions;
	}

	public Perception getPeception() {
		return peception;
	}

	public void setPeception(Perception peception) {
		this.peception = peception;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public Perception seeEnvironment(Environment env) {
		Perception p = new Perception();
		
		if(env.isAgentLocation()) {
			p.setLocation(true);
			p.setDirty(!env.isDirtyA());
		} else {
			p.setLocation(false);
			p.setDirty(!env.isDirtyB());
		}
		
		return p;
	}

	public abstract void changeEnvironment(Environment env);
	
}
