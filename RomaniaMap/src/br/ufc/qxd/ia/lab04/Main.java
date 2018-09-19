package br.ufc.qxd.ia.lab04;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ufc.qxd.ia.lab02.Action;
import br.ufc.qxd.ia.lab02.Model;
import br.ufc.qxd.ia.lab02.State;
import br.ufc.qxd.ia.lab03.Problem;
import br.ufc.qxd.ia.lab03.SearchForASolution;

public class Main {

	public static void main(String[] args) {
		
		Model model = new Model();
		
		Map<State, Integer> hDLR_bucharest = new HashMap<>();
		hDLR_bucharest.put(model.getStateByName("Arad"), 366);
		hDLR_bucharest.put(model.getStateByName("Bucharest"), 0);
		hDLR_bucharest.put(model.getStateByName("Craiova"), 160);
		hDLR_bucharest.put(model.getStateByName("Drobeta"), 242);
		hDLR_bucharest.put(model.getStateByName("Eforie"), 161);
		hDLR_bucharest.put(model.getStateByName("Fagaras"), 176);
		hDLR_bucharest.put(model.getStateByName("Giurgiu"), 77);
		hDLR_bucharest.put(model.getStateByName("Hirsova"), 151);
		hDLR_bucharest.put(model.getStateByName("Iasi"), 226);
		hDLR_bucharest.put(model.getStateByName("Lugoj"), 244);
		hDLR_bucharest.put(model.getStateByName("Mehadia"), 241);
		hDLR_bucharest.put(model.getStateByName("Neamt"), 234);
		hDLR_bucharest.put(model.getStateByName("Oradea"), 380);
		hDLR_bucharest.put(model.getStateByName("Pitesti"), 100);
		hDLR_bucharest.put(model.getStateByName("Rimnicu Vilcea"), 193);
		hDLR_bucharest.put(model.getStateByName("Sibiu"), 253);
		hDLR_bucharest.put(model.getStateByName("Timisoara"), 329);
		hDLR_bucharest.put(model.getStateByName("Urziceni"), 80);
		hDLR_bucharest.put(model.getStateByName("Vaslui"), 199);
		hDLR_bucharest.put(model.getStateByName("Zerind"), 374);
		
		State start = model.getStateByName(args[1]);
		State end = model.getStateByName("Bucharest");
		Problem p = new Problem(start, null, model, end);
		
		SearchForASolution search = new SearchForASolution(p, hDLR_bucharest);
		
//		List<Action> solution = search.widthSearch();
//		if(solution == null)
//			System.out.println("Falha");
//		else if(solution.isEmpty()) {
//			System.out.println("Custo total: " + 0);
//		} else {
//			for(int i = solution.size() - 1; i >= 0; i--) System.out.println(solution.get(i).getName());
//			System.out.println();
//			System.out.println("Custo total: " + p.getCostByWay());
//		}
		
		List<Action> solution = null;
		if(args[0].equals("Guloso")) {
			solution = search.greedySearchForBestChoice();
		} else if(args[0].equals("Aestrela")) {
			solution = search.aStarSearch();
		}
		
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
