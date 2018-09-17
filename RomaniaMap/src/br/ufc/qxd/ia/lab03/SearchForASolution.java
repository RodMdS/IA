package br.ufc.qxd.ia.lab03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import br.ufc.qxd.ia.lab02.Action;
import br.ufc.qxd.ia.lab02.State;
import br.ufc.qxd.ia.lab02.Transition;

public class SearchForASolution {
	
	private Problem problem;
	private List<Action> solution;
	
	public SearchForASolution(Problem problem) {
		this.problem = problem;
		this.solution = new ArrayList<Action>();
	}
	
	public List<Action> widthSearch() {
		List<State> explorados = new ArrayList<>();
 		Queue<Node> borda = new LinkedList<>();
 		
 		Node root = new Node(problem.getInitial(), null, 0, null);
		borda.add(root);
		
		if(problem.getEnd().getName().equals(root.getState().getName())) return solution;
		
		while(true) {
			if(borda.isEmpty()) return null;
			Node no = borda.remove();
			explorados.add(no.getState());
			
			for(Transition t : no.getState().getNeighbors()) {
				Node son = new Node();
				son.setState(t.getDestiny());
				son.setActionByFather(t.getAction());
				son.setCostOfTheWay(no.getCostOfTheWay() + t.getAction().getWeight());
				son.setFather(no);
				
				if((!explorados.contains(son.getState())) || (!borda.contains(son))) {
					if(problem.getEnd().getName().equals(son.getState().getName())) {
						//System.out.println("uhu");
						problem.setCostByWay(son.getCostOfTheWay());
						while(son.getFather() != null) {
							solution.add(son.getActionByFather());
							son = son.getFather();
						}
						return solution;
					}
					
					borda.add(son);
				}
				
			}
			
		}
		
	}

	
}
