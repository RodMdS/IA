package br.ufc.qxd.ia.lab02;

import java.util.ArrayList;
import java.util.List;

public class Model {
	
	private List<State> states;
	
	public Model() {
		states = new ArrayList<State>();
		this.fillModel();
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}
	
	public State getStateByName(String name) {
		State state = null;
		
		for(State s : states) {
			if(s.getName().equals(name)) return s;
		}
		
		return state;
	}
	
	private void fillModel() {
		State s0 = new State("Arad");
		State s1 = new State("Oradea");
		State s2 = new State("Zerind");
		State s3 = new State("Timisoara");
		State s4 = new State("Lugoj");
		State s5 = new State("Mehadia");
		State s6 = new State("Drobeta");
		State s7 = new State("Craiova");
		State s8 = new State("Rimnicu Vilcea");
		State s9 = new State("Sibiu");
		State s10 = new State("Fagaras");
		State s11 = new State("Pitesti");
		State s12 = new State("Bucharest");
		State s13 = new State("Giurgiu");
		State s14 = new State("Urziceni");
		State s15 = new State("Eforie");
		State s16 = new State("Hirsova");
		State s17 = new State("Vaslui");
		State s18 = new State("Iasi");
		State s19 = new State("Neamt");
		
		s0.getNeighbors().add(new Transition(null, s2, new Action("arad-zerind", 75)));
		s0.getNeighbors().add(new Transition(null, s3, new Action("arad-timisoara", 118)));
		s0.getNeighbors().add(new Transition(null, s9, new Action("arad-sibiu", 140)));
		
		s1.getNeighbors().add(new Transition(null, s2, new Action("oradea-zerind", 71)));
		s1.getNeighbors().add(new Transition(null, s9, new Action("oradea-sibiu", 151)));
		
		s2.getNeighbors().add(new Transition(null, s0, new Action("zerind-arad", 75)));
		s2.getNeighbors().add(new Transition(null, s1, new Action("zerind-oradea", 71)));
		
		s3.getNeighbors().add(new Transition(null, s0, new Action("timisoara-arad", 118)));
		s3.getNeighbors().add(new Transition(null, s4, new Action("timisoara-lugoj", 111)));
		
		s4.getNeighbors().add(new Transition(null, s3, new Action("lugoj-timisoara", 111)));
		s4.getNeighbors().add(new Transition(null, s5, new Action("lugoj-mehadia", 70)));
		
		s5.getNeighbors().add(new Transition(null, s4, new Action("mehadia-lugoj", 70)));
		s5.getNeighbors().add(new Transition(null, s6, new Action("mehadia-drobeta", 75)));
		
		s6.getNeighbors().add(new Transition(null, s5, new Action("drobeta-mehadia", 75)));
		s6.getNeighbors().add(new Transition(null, s7, new Action("drobeta-craiova", 120)));
		
		s7.getNeighbors().add(new Transition(null, s6, new Action("craiova-drobeta", 120)));
		s7.getNeighbors().add(new Transition(null, s8, new Action("craiova-RV", 146)));
		s7.getNeighbors().add(new Transition(null, s11, new Action("craiova-pitesti", 138)));
		
		s8.getNeighbors().add(new Transition(null, s9, new Action("RV-sibiu", 80)));
		s8.getNeighbors().add(new Transition(null, s11, new Action("RV-pitesti", 97)));
		
		s9.getNeighbors().add(new Transition(null, s0, new Action("sibiu-arad", 140)));
		s9.getNeighbors().add(new Transition(null, s1, new Action("sibiu-oradea", 151)));
		s9.getNeighbors().add(new Transition(null, s8, new Action("sibiu-RV", 80)));
		s9.getNeighbors().add(new Transition(null, s10, new Action("sibiu-fagaras", 99)));
		
		s10.getNeighbors().add(new Transition(null, s9, new Action("fagaras-sibiu", 99)));
		s10.getNeighbors().add(new Transition(null, s12, new Action("fagaras-bucharest", 211)));
		
		s11.getNeighbors().add(new Transition(null, s7, new Action("pitesti-craiova", 138)));
		s11.getNeighbors().add(new Transition(null, s8, new Action("pitesti-RV", 97)));
		s11.getNeighbors().add(new Transition(null, s12, new Action("pitesti-bucharest", 101)));
		
		s12.getNeighbors().add(new Transition(null, s10, new Action("bucharest-fagaras", 211)));
		s12.getNeighbors().add(new Transition(null, s11, new Action("bucharest-pitesti", 101)));
		s12.getNeighbors().add(new Transition(null, s13, new Action("bucharest-giurgiu", 90)));
		s12.getNeighbors().add(new Transition(null, s14, new Action("bucharest-urziceni", 85)));
		
		s13.getNeighbors().add(new Transition(null, s12, new Action("giurgiu-bucharest", 90)));
		
		s14.getNeighbors().add(new Transition(null, s12, new Action("urziceni-bucharest", 85)));
		s14.getNeighbors().add(new Transition(null, s16, new Action("urziceni-hirsova", 98)));
		s14.getNeighbors().add(new Transition(null, s17, new Action("urziceni-vaslui", 142)));
		
		s15.getNeighbors().add(new Transition(null, s16, new Action("eforie-hirsova", 86)));
		
		s16.getNeighbors().add(new Transition(null, s14, new Action("hirsova-urziceni", 98)));
		s16.getNeighbors().add(new Transition(null, s15, new Action("hirsova-eforie", 86)));
		
		s17.getNeighbors().add(new Transition(null, s14, new Action("vaslui-urziceni", 142)));
		s17.getNeighbors().add(new Transition(null, s18, new Action("vaslui-iasi", 92)));
		
		s18.getNeighbors().add(new Transition(null, s17, new Action("iasi-vaslui", 92)));
		s18.getNeighbors().add(new Transition(null, s19, new Action("iasi-neamt", 87)));
		
		s19.getNeighbors().add(new Transition(null, s18, new Action("neamt-iasi", 87)));
		
		states.add(s0);
		states.add(s1);
		states.add(s2);
		states.add(s3);
		states.add(s4);
		states.add(s5);
		states.add(s6);
		states.add(s7);
		states.add(s8);
		states.add(s9);
		states.add(s10);
		states.add(s11);
		states.add(s12);
		states.add(s13);
		states.add(s14);
		states.add(s15);
		states.add(s16);
		states.add(s17);
		states.add(s18);
		states.add(s19);
	}
	
	public List<Transition> getNeighborsByState(State s) {
		for(State st : this.states) {
			if(st.getName().equals(s.getName())) {
				return st.getNeighbors();
			}
		}
		return null;
	}
	
	public int getCustoByTransicao(State origem, State destino) {
		for(Transition t : origem.getNeighbors()) {
			if(t.getDestiny().getName().equals(destino.getName())) {
				return t.getAction().getWeight();
			}
		}
		
		return 0;
	}

}
