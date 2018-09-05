package br.ufc.qxd.ia.lab02;

import java.util.ArrayList;
import java.util.List;

public class State {
	
	private String name;
	private List<Transition> neighbors;

	public State(String name) {
		this.name = name;
		this.neighbors = new ArrayList<Transition>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Transition> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(List<Transition> neighbors) {
		this.neighbors = neighbors;
	}

}
