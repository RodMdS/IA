package br.ufc.qxd.ia.lab02;

import java.util.ArrayList;
import java.util.List;

public class Model {
	
	private List<State> states;
	//private List<Transition> transitions;
	
	public Model(List<State> states /*, List<Transition> transitions*/) {
		this.states = states;
		//this.transitions = transitions;
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

//	public List<Transition> getTransitions() {
//		return transitions;
//	}
//
//	public void setTransitions(List<Transition> transitions) {
//		this.transitions = transitions;
//	}
	
	
	
	public List<Transition> getNeighborsByState(State s) {
		List<State> neighbors = new ArrayList<>();
		
		for(State st : this.states) {
			if(st.getName().equals(s.getName())) {
				return st.getNeighbors(); 
			}
		}
		
		return null;
	}

}
