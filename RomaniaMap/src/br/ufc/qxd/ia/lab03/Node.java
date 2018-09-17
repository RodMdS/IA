package br.ufc.qxd.ia.lab03;

import br.ufc.qxd.ia.lab02.Action;
import br.ufc.qxd.ia.lab02.State;

public class Node {
	
	private State state;
	private int costOfTheWay;
	private Action actionByFather;
	private Node father;
	
	public Node() {}
	
	public Node(State state, Action actionByFather, int costOfTheWay, Node father) {
		this.state = state;
		this.actionByFather = actionByFather;
		this.costOfTheWay = costOfTheWay;
		this.father = father;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Action getActionByFather() {
		return actionByFather;
	}

	public void setActionByFather(Action actionByFather) {
		this.actionByFather = actionByFather;
	}

	public int getCostOfTheWay() {
		return costOfTheWay;
	}

	public void setCostOfTheWay(int costOfTheWay) {
		this.costOfTheWay = costOfTheWay;
	}

	public Node getFather() {
		return father;
	}

	public void setFather(Node father) {
		this.father = father;
	}

}
