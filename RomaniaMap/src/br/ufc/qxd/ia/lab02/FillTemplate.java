package br.ufc.qxd.ia.lab02;

import java.util.ArrayList;
import java.util.List;

public class FillTemplate {

	public static void main(String[] args) {
		
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
		
		s0.getNeighbors().add(new Transition(null, s2, new Action("", 75)));
		s0.getNeighbors().add(new Transition(null, s3, new Action("", 118)));
		s0.getNeighbors().add(new Transition(null, s9, new Action("", 140)));
		
		s1.getNeighbors().add(new Transition(null, s2, new Action("", 71)));
		s1.getNeighbors().add(new Transition(null, s9, new Action("", 151)));
		
		s2.getNeighbors().add(new Transition(null, s0, new Action("", 75)));
		s2.getNeighbors().add(new Transition(null, s1, new Action("", 71)));
		
		s3.getNeighbors().add(new Transition(null, s0, new Action("", 118)));
		s3.getNeighbors().add(new Transition(null, s4, new Action("", 111)));
		
		s4.getNeighbors().add(new Transition(null, s3, new Action("", 111)));
		s4.getNeighbors().add(new Transition(null, s5, new Action("", 70)));
		
		s5.getNeighbors().add(new Transition(null, s4, new Action("", 70)));
		s5.getNeighbors().add(new Transition(null, s6, new Action("", 75)));
		
		s6.getNeighbors().add(new Transition(null, s5, new Action("", 75)));
		s6.getNeighbors().add(new Transition(null, s7, new Action("", 120)));
		
		s7.getNeighbors().add(new Transition(null, s6, new Action("", 120)));
		s7.getNeighbors().add(new Transition(null, s8, new Action("", 146)));
		s7.getNeighbors().add(new Transition(null, s11, new Action("", 138)));
		
		s8.getNeighbors().add(new Transition(null, s9, new Action("", 80)));
		s8.getNeighbors().add(new Transition(null, s11, new Action("", 97)));
		
		s9.getNeighbors().add(new Transition(null, s0, new Action("", 140)));
		s9.getNeighbors().add(new Transition(null, s1, new Action("", 151)));
		s9.getNeighbors().add(new Transition(null, s8, new Action("", 80)));
		s9.getNeighbors().add(new Transition(null, s10, new Action("", 99)));
		
		s10.getNeighbors().add(new Transition(null, s9, new Action("", 99)));
		s10.getNeighbors().add(new Transition(null, s12, new Action("", 211)));
		
		s11.getNeighbors().add(new Transition(null, s7, new Action("", 138)));
		s11.getNeighbors().add(new Transition(null, s8, new Action("", 97)));
		s11.getNeighbors().add(new Transition(null, s12, new Action("", 101)));
		
		s12.getNeighbors().add(new Transition(null, s10, new Action("", 211)));
		s12.getNeighbors().add(new Transition(null, s11, new Action("", 101)));
		s12.getNeighbors().add(new Transition(null, s13, new Action("", 90)));
		s12.getNeighbors().add(new Transition(null, s14, new Action("", 85)));
		
		s13.getNeighbors().add(new Transition(null, s12, new Action("", 90)));
		
		s14.getNeighbors().add(new Transition(null, s12, new Action("", 85)));
		s14.getNeighbors().add(new Transition(null, s16, new Action("", 98)));
		s14.getNeighbors().add(new Transition(null, s17, new Action("", 142)));
		
		s15.getNeighbors().add(new Transition(null, s16, new Action("", 86)));
		
		s16.getNeighbors().add(new Transition(null, s14, new Action("", 98)));
		s16.getNeighbors().add(new Transition(null, s15, new Action("", 86)));
		
		s17.getNeighbors().add(new Transition(null, s14, new Action("", 142)));
		s17.getNeighbors().add(new Transition(null, s18, new Action("", 92)));
		
		s18.getNeighbors().add(new Transition(null, s17, new Action("", 92)));
		s18.getNeighbors().add(new Transition(null, s19, new Action("", 87)));
		
		s19.getNeighbors().add(new Transition(null, s18, new Action("", 87)));
		
		List<State> states = new ArrayList<State>();
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
		
		Model model = new Model(states);
		
		for(Transition t : model.getNeighborsByState(s12)) {
			System.out.println(s12.getName() + " " + t.getDestiny().getName() + " " + t.getAction().getWeight());
		}
		
		System.out.println();
		System.out.println("Modelo completo");
		System.out.println("Origem Destino Custo");
		System.out.println();
		
		for(State s : model.getStates()) {
			for(Transition t : model.getNeighborsByState(s)) {
				System.out.println(s.getName() + " " + t.getDestiny().getName() + " " + t.getAction().getWeight());
			}
		}
	}
	
}
