package br.ufc.qxd.ia.lab03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import br.ufc.qxd.ia.lab02.Action;
import br.ufc.qxd.ia.lab02.State;
import br.ufc.qxd.ia.lab02.Transition;

public class SearchForASolution {

	private Problem problem;
	private List<Action> solution = new ArrayList<>();
	private Map<State,Integer> hDLR_bucharest;

	public SearchForASolution(Problem problem, Map<State,Integer> hDLR_bucharest) {
		this.problem = problem;
		this.solution = new ArrayList<Action>();
		this.hDLR_bucharest = hDLR_bucharest;
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

	public List<Action> deepSearch() {
		List<State> explorados = new ArrayList<>();
		List<Node> borda = new LinkedList<>(); // simular uma pilha

		Node root = new Node(problem.getInitial(), null, 0, null);
		borda.add(0, root);

		if(problem.getEnd().getName().equals(root.getState().getName())) return solution;

		while(true) {
			if(borda.isEmpty()) return null;
			Node no = borda.remove(0);
			//System.out.println("Removeu: " + no.getState().getName());
			//borda.remove(0);
			explorados.add(no.getState());	

			for(Transition t : no.getState().getNeighbors()) {
				Node son = new Node();
				son.setState(t.getDestiny());
				son.setActionByFather(t.getAction());
				son.setCostOfTheWay(no.getCostOfTheWay() + t.getAction().getWeight());
				son.setFather(no);

				if((!explorados.contains(son.getState())) /*|| (!borda.contains(son))*/) {
					if(problem.getEnd().getName().equals(son.getState().getName())) {
						problem.setCostByWay(son.getCostOfTheWay());
						while(son.getFather() != null) {
							solution.add(son.getActionByFather());
							son = son.getFather();
						}
						return solution;
					}

					borda.add(0, son);
				}

			}

		}
	}
	
	private Node getNodeByCost2(PriorityQueue<Node> borda) {
		Node result = borda.element();
		
		for(Node no : borda) {
			if(no.getCostOfTheWay() < result.getCostOfTheWay()) {
				result = no;
			}
		}
		
		return result;
	}
	
	public List<Action> uniformCostSearch() {
		List<State> explorados = new ArrayList<>();
		PriorityQueue<Node> borda = new PriorityQueue<>();

		Node root = new Node(problem.getInitial(), null, 0, null);
		borda.add(root);

		while(true) {
			if(borda.isEmpty()) return null;

			Node no = getNodeByCost2(borda);
			borda.remove(no);

			if(no.getState().getName().equals(problem.getEnd().getName())) {
				problem.setCostByWay(no.getCostOfTheWay());
				while(no.getFather() != null) {
					solution.add(no.getActionByFather());
					no = no.getFather();
				}
				return solution;
			}

			explorados.add(no.getState());

			for(Transition t : no.getState().getNeighbors()) {
				Node son = new Node();
				son.setState(t.getDestiny());
				son.setActionByFather(t.getAction());
				int custoPrevisto = no.getCostOfTheWay() + t.getAction().getWeight();
				son.setCostOfTheWay(custoPrevisto);
				son.setFather(no);

				if(!borda.contains(son) || !explorados.contains(son.getState())) {
					borda.add(son);
				} else {
					for(Node n : borda) {
						if(n.getState().getName().equals(son.getState().getName())) {
							if(n.getCostOfTheWay() > custoPrevisto) {
								n.setState(son.getState());
								n.setFather(son.getFather());
								n.setActionByFather(son.getActionByFather());
								n.setCostOfTheWay(custoPrevisto);
							}
						}
					}
				}
				
			}
			
		}
		
	}

	private Node getNodeByCost(PriorityQueue<Node> borda) {
		Node result = borda.element();
		
		for(Node no : borda) {
			if(hDLR_bucharest.get(no.getState()) < hDLR_bucharest.get(result.getState())) {
				result = no;
			}
		}
		
		return result;
	}
	
	public List<Action> greedySearchForBestChoice() {
		List<State> explorados = new ArrayList<>();
		PriorityQueue<Node> borda = new PriorityQueue<>();

		Node root = new Node(problem.getInitial(), null, 0, null);
		borda.add(root);

		while(true) {
			if(borda.isEmpty()) return null;

			Node no = getNodeByCost(borda);
			borda.remove(no);

			if(no.getState().getName().equals(problem.getEnd().getName())) {
				problem.setCostByWay(no.getCostOfTheWay());
				while(no.getFather() != null) {
					solution.add(no.getActionByFather());
					no = no.getFather();
				}
				return solution;
			}

			explorados.add(no.getState());

			for(Transition t : no.getState().getNeighbors()) {
				Node son = new Node();
				son.setState(t.getDestiny());
				son.setActionByFather(t.getAction());
				int custoPrevisto = no.getCostOfTheWay() + t.getAction().getWeight();
				son.setCostOfTheWay(custoPrevisto);
				son.setFather(no);

				if(!borda.contains(son) || !explorados.contains(son.getState())) {
					borda.add(son);
				} else {
					for(Node n : borda) {
						if(n.getState().getName().equals(son.getState().getName())) {
							if(n.getCostOfTheWay() > custoPrevisto) {
								n.setState(son.getState());
								n.setFather(son.getFather());
								n.setActionByFather(son.getActionByFather());
								n.setCostOfTheWay(custoPrevisto);
							}
						}
					}
				}
			}
		}
	}

	public List<Action> aStarSearch() {
		List<State> explorados = new ArrayList<>();
		PriorityQueue<Node> borda = new PriorityQueue<>();

		Node root = new Node(problem.getInitial(), null, 0, null);
		borda.add(root);

		while(true) {
			if(borda.isEmpty()) return null;

			Node no = borda.poll();

			if(no.getState().getName().equals(problem.getEnd().getName())) {
				problem.setCostByWay(no.getCostOfTheWay());
				while(no.getFather() != null) {
					solution.add(no.getActionByFather());
					no = no.getFather();
				}
				return solution;
			}

			explorados.add(no.getState());

			for(Transition t : no.getState().getNeighbors()) {
				Node son = new Node();
				son.setState(t.getDestiny());
				son.setActionByFather(t.getAction());
				son.setFather(no);
				
				Node aux = son;
				
				int custoAteOPai = 0;
				while(aux.getFather() != null) {
					custoAteOPai += problem.getModel().getCustoByTransicao(aux.getFather().getState(), aux.getState());
					aux = aux.getFather();
				}
				
				int custoPrevisto = custoAteOPai + hDLR_bucharest.get(t.getDestiny());
				son.setCostOfTheWay(custoPrevisto);
				
				if(!borda.contains(son) || !explorados.contains(son.getState())) {
					borda.add(son);
				} else {
					for(Node n : borda) {
						if(n.getState().getName().equals(son.getState().getName())) {
							if(n.getCostOfTheWay() > custoPrevisto) {
								n.setState(son.getState());
								n.setFather(son.getFather());
								n.setActionByFather(son.getActionByFather());
								n.setCostOfTheWay(custoPrevisto);
							}
						}
					}
				}
			}
		}
	}
	
}
