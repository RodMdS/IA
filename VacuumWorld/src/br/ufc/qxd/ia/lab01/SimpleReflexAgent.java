package br.ufc.qxd.ia.lab01;

import java.util.List;

public class SimpleReflexAgent extends Agent {

	public SimpleReflexAgent(Perception perception, List<Action> actions) {
		super(perception, actions);
	}
	
	private Action getAction(Perception p) {
		Action a = new Action();
		
		if(p.isDirty()) {
			a.setName("Aspire");
			return a;
		} else {
			if(p.isLocation()) { // agente está na sala A
				a.setName("Right");
				return a;
			} else {
				a.setName("Left");
				return a;
			}
		}
	}

	@Override
	public void changeEnvironment(Environment env) {
		Perception p = this.seeEnvironment(env);
		this.setPeception(p); // modificar a última percepão que o agente observou
		
		Action a = this.getAction(p);
		this.getActions().add(a); // armazenar uma lista de ações tomadas pelo agente
		System.out.println("Action taken: " + a.getName());
		
		if(a.getName().equals("Aspire")) {
			if(env.isAgentLocation()) {
				env.setDirtyA(true);
			} else {
				env.setDirtyB(true);
			}
		} else if(a.getName().equals("Right")) {
			env.setAgentLocation(false);
		} else if(a.getName().equals("Left")) {
			env.setAgentLocation(true);
		}
		
		System.out.println(env.toString());
	}

}
