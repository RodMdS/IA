package br.ufc.qxd.ia.lab03;

import java.util.Set;

import br.ufc.qxd.ia.lab02.Action;
import br.ufc.qxd.ia.lab02.Model;
import br.ufc.qxd.ia.lab02.State;

public class Problem {

	private State initial;
	private Set<Action> actions;
	private Model model;
	private State end;
	private int costByWay = 0;
	
	public Problem(State initial, Set<Action> actions, Model model, State end) {
		this.initial = initial;
		this.actions = actions;
		this.model = model;
		this.end = end;
	}

	public State getInitial() {
		return initial;
	}

	public void setInitial(State initial) {
		this.initial = initial;
	}

	public Set<Action> getActions() {
		return actions;
	}

	public void setActions(Set<Action> actions) {
		this.actions = actions;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public State getEnd() {
		return end;
	}

	public void setEnd(State end) {
		this.end = end;
	}

	public int getCostByWay() {
		return costByWay;
	}

	public void setCostByWay(int costByWay) {
		this.costByWay = costByWay;
	}
	
}
