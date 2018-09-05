package br.ufc.qxd.ia.lab02;

public class Transition {
	
	private State origin;
	private State destiny;
	private Action action;
	
	public Transition(State origin, State destiny, Action action) {
		this.origin = origin;
		this.destiny = destiny;
		this.action = action;
	}

	public State getOrigin() {
		return origin;
	}

	public void setOrigin(State origin) {
		this.origin = origin;
	}

	public State getDestiny() {
		return destiny;
	}

	public void setDestiny(State destiny) {
		this.destiny = destiny;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

}
