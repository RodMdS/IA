package br.ufc.qxd.ia.lab03;

import java.util.List;

import br.ufc.qxd.ia.lab02.Action;
import br.ufc.qxd.ia.lab02.Model;
import br.ufc.qxd.ia.lab02.State;

public class Main {

	public static void main(String[] args) {
		
		Model model = new Model();
		
		State s1 = model.getStateByName(args[0]);
		State s6 = model.getStateByName(args[1]);
		Problem p = new Problem(s1, null, model, s6);
		
		SearchForASolution search = new SearchForASolution(p);
		
		List<Action> solution = search.widthSearch();
		if(solution == null)
			System.out.println("Falha");
		else if(solution.isEmpty()) {
			System.out.println("Custo total: " + 0);
		} else {
			for(int i = solution.size() - 1; i >= 0; i--) System.out.println(solution.get(i).getName());
			System.out.println();
			System.out.println("Custo total: " + p.getCostByWay());
		}

	}

}
