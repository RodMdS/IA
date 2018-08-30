package br.ufc.qxd.ia.lab01;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Iana Mary Gomes Costa and Rodrigo Machado dos Santos
 * @university Universidade Federal do Ceará
 * @course Ciência da Computação
 **
 */
public class Main {
	
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Sala A está limpa?");
		boolean isDirtyA = leitor.nextBoolean();
		
		System.out.println("Sala B está limpa?");
		boolean isDirtyB = leitor.nextBoolean();
		
		System.out.println("O agente está na sala A?");
		boolean agenteLocation = leitor.nextBoolean();
		
		System.out.println("Quantos passos quer que o agente execute?");
		int n = leitor.nextInt();
		
		Environment env = new Environment(isDirtyA, isDirtyB, agenteLocation);
		
		Agent agente2 = new SimpleReflexAgent(new Perception(), new ArrayList<Action>());
		
		System.out.println(); // frescura estética
		System.out.println(env.toString());
		
		while(n > 0) {
			agente2.changeEnvironment(env);
			n--;
		}
		
		leitor.close();
	}

}
