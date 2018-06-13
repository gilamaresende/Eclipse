package principal;

import java.util.ArrayList;

import entrada.Teclado;
import militares.Cabo;
import militares.Sargento;
import militares.Soldado;
import militares.Tenente;
import objetos.Conquitar15Pais;
import objetos.Continente;
import objetos.Jogador;
import objetos.Objetivo;
import objetos.Pais;

public class Rodada {
	int nRodada;
	Conquitar15Pais obj;
	public Rodada() {
		nRodada = 0;
		obj = new Conquitar15Pais();
			
			
	}
	
	//mensagem no fim do jogo
	public void fimDeJogo() {
		int quantidadeMilitar = 0;
		
		for (Pais p : obj.getVencedor().getPais() ) {
			quantidadeMilitar = quantidadeMilitar + p.getContaSoldado();
		}
	
		System.out.println("Vencedor: Jogador " + obj.getVencedor().getCor());
		System.out.println("Paises Conquistador: " + obj.getVencedor().getPais().size());
		System.out.println("Quantidade Total de Militares " + quantidadeMilitar);
		System.out.println("Duração: " + nRodadas() + " Rodadas");
	}
	
	
	public void adicionarExercito(ArrayList<Jogador> playes) {
		
		for (Jogador p : playes) {
			
			p.addMilitar();
			
		}
	}
	//contador de rodadas
	public void rodadaNova() {
		nRodada++;
	}
	
	//retorna o numero de rodadas do jogo
	public int nRodadas() {
		return nRodada;
	}
	
	//verificar se algum jogador é dono de algum continente
	public void bonus(ArrayList<Jogador> playes, ArrayList<Continente> mundo) {
		boolean ganhouBonus = true;
		for (Jogador j : playes) {
			for(Continente c : mundo) {
				for(Pais p : c.getPaises()){
					if(j == p.getDono()) {
						ganhouBonus = true;
					}
					else {
						ganhouBonus = false;
						break;
					}
				}
				if(ganhouBonus) {
					distribuirBonus(c, j);
				}
				
			}
			
				
			
			
			
		}
		
	}
	
	
	//adicionar militares bonus
	private void distribuirBonus(Continente c, Jogador j) {
		System.out.println("Jogador " + j.getCor() + " Ganhou Bonus");
		if(c.getNome().equals("Europa")) {
			j.addBonus(new Soldado());
			j.addBonus(new Cabo());
			j.addBonus(new Sargento());
			j.addBonus(new Soldado());
			j.addBonus(new Cabo());
			j.addBonus(new Sargento());
		}
		else if(c.getNome().equals("Asia")) {
			j.addBonus(new Soldado());
			j.addBonus(new Soldado());
			j.addBonus(new Cabo());
			j.addBonus(new Cabo());
			j.addBonus(new Sargento());
			j.addBonus(new Tenente());
		}
		else if(c.getNome().equals("America do Sul")) {
			j.addBonus(new Soldado());
			j.addBonus(new Soldado());
			j.addBonus(new Cabo());
			j.addBonus(new Sargento());
		
		}
		else if(c.getNome().equals("Continente Africano")) {
			j.addBonus(new Soldado());
			j.addBonus(new Soldado());
			j.addBonus(new Cabo());
			j.addBonus(new Cabo());
			j.addBonus(new Tenente());
			j.addBonus(new Sargento());
		}
		else if(c.getNome().equals("Oceania")) {
			j.addBonus(new Soldado());
			j.addBonus(new Cabo());
			j.addBonus(new Sargento());
		}
		else if(c.getNome().equals("America do Norte")) {
			j.addBonus(new Soldado());
			j.addBonus(new Soldado());
			j.addBonus(new Cabo());
			j.addBonus(new Cabo());
			j.addBonus(new Tenente());
			j.addBonus(new Sargento());
		}
	}
	
	//verificar se algum jogador concluiu o objetivo
	public boolean verificarVencedor(ArrayList<Jogador> play) {
		for(Jogador j : play) {
			
			
			if(obj.ifConcluido(j)) {
				return true;
			}
			
		}
		return false;
		
		
	}
	//menu de acao antes de mover
	public void acoes(ArrayList<Jogador> playes) {
		int op;
		
		
		for (Jogador p : playes) {
			while(true) {
				corJogador(p);
				acoesPrint();
				op = entrada();
				while(op < 1 || op > 4) {
					erroPrint();
					op = entrada();
				}
				if(op == 1) {
					
					p.mostrarPaises();
				}
				else if(op == 2) {
					p.atk();
				}
				else if(op == 3) {
					p.mover();
					acoes2(p);
					break;
				}
				else {
					
					break;
				}
					
			}
	
		}
		
		
	}
	//menu de acao depois de mover nao pode mais atakar
	public void acoes2(Jogador p) {
		int op;
		while(true) {
			corJogador(p);
			acoesPrint2();
			op = entrada();
			while(op < 1 || op > 3) {
				erroPrint();
				op = entrada();
			}
			if(op == 1) {
				
				p.mostrarPaises();
			}
			else if(op == 2) {
				p.mover();
			}
			else {
				break;
			}
				
		}
	}
	//seta cores disponiveis
	public void corJogador(Jogador j) {
		System.out.println("Jogador " + j.getCor());
	}
	
	//mostrar acoes que jogador pode realizar antes de mover
	public void acoesPrint() {
		System.out.println("Acoes");
		System.out.println("1 - Mostrar todos seus paises");
		System.out.println("2 - Atacar");
		System.out.println("3 - Mover exercito");
		System.out.println("4 - Passar a vez");
	}
	//mostrar acoes que jogador pode realizar mover de mover
	public void acoesPrint2() {
		System.out.println("Acoes");
		System.out.println("1 - Mostrar todos seus paises");
		System.out.println("2 - Mover exercito");
		System.out.println("3 - Passar a vez");
	}
	
	//ler dado do teclado
	public int entrada() {
		Teclado tc = new Teclado();
		return tc.teclado();
	}
	
	
	//mensagem do entrada do teclado incorreta
	public void erroPrint() {
		System.out.println("Opcao incorreta\nTente Novamente");
	}
}



