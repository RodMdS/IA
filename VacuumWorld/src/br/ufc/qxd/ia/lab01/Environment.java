package br.ufc.qxd.ia.lab01;

public class Environment {
	
	private boolean isDirtyA;
	private boolean isDirtyB;
	private boolean agentLocation;
	
	public Environment(boolean isDirtyA, boolean isDirtyB, boolean agentLocation) {
		this.isDirtyA = isDirtyA;
		this.isDirtyB = isDirtyB;
		this.agentLocation = agentLocation;
	}

	public boolean isDirtyA() {
		return isDirtyA;
	}

	public void setDirtyA(boolean isDirtyA) {
		this.isDirtyA = isDirtyA;
	}

	public boolean isDirtyB() {
		return isDirtyB;
	}

	public void setDirtyB(boolean isDirtyB) {
		this.isDirtyB = isDirtyB;
	}

	public boolean isAgentLocation() {
		return agentLocation;
	}

	public void setAgentLocation(boolean agentLocation) {
		this.agentLocation = agentLocation;
	}

	@Override
	public String toString() {
		return "Environment = [isDirtyA=" + isDirtyA + ", isDirtyB=" + isDirtyB + ", agentLocation=" + agentLocation + "]";
	}
}
