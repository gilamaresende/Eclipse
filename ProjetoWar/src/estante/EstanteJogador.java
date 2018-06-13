package estante;

import java.util.ArrayList;


import entrada.Teclado;
import objetos.Conquitar15Pais;
import objetos.Jogador;
import objetos.Objetivo;
import principal.Dice;



public class EstanteJogador {
	private ArrayList <Jogador> plays;
	private ArrayList <Jogador> ordemDeAtk;
	private ArrayList <String> cor;
	
	public EstanteJogador() {
		plays = new ArrayList<Jogador>();
		ordemDeAtk = new ArrayList<Jogador>();
		
		
		
		this.setCor();
		this.montarEstante();
	}


	//escolhe a quantidade de jogadores
	private void montarEstante() {
		
		int quantidade;
		
		this.quantidadeDeJogadoores();
		quantidade = teclado();
		
		while(quantidade < 2 || quantidade > 4) {
			this.quantidadeJogadorIncorreta();
			quantidade = teclado();
		}
		criarJogador(quantidade);
	}
	
	//criar os jogadores
	private void criarJogador(int quantidade) {
		
		
		for (int i = 0; i < quantidade; i++) {
			
			plays.add(new Jogador(cor));
		}
	}
	
	//escolher ordem de jogar
	public void ordenaAtk() {
		
		int n;
		Dice dado = new Dice();
		ArrayList<Jogador> copPlay = new ArrayList<Jogador>();
		

		for (Jogador c : plays) {
			copPlay.add(c);
		}
		
		
		for (int i = 0; i < plays.size(); i++) {
			n = dado.playsorte(copPlay.size());
			ordemDeAtk.add(copPlay.get(n));
			copPlay.remove(n);
		}
	}

	//Entrada pelo teclado
	public int teclado() {
		Teclado tc = new Teclado();
		return tc.teclado();
	}
	

	
	//Set cores que os jogadores podem scolher
	public void setCor() {
		cor = new ArrayList<String>();
		cor.add("Preto");
		cor.add("Branco");
		cor.add("Azul");
		cor.add("Amarelo");
	}
	
	//retorna lista de jogadores
	public ArrayList<Jogador> getPlayes(){
		return this.plays;
	}
	
	//retorna ordem de jogo
	public ArrayList<Jogador> getOrdem(){
		return this.ordemDeAtk;
	}
	
	//Prints de mensagens
	/////////////////////////////////////////////////////////////////////////////
	//perguntar quatidade de jogadores
	private void quantidadeDeJogadoores() {
		System.out.println("Entre com a quantidade de Jogadores");
	}
	
	//mensagem de erro
	private void quantidadeJogadorIncorreta() {
		System.out.println("Minimo de Jogadores sao 2 e Maximo de jogadores sao 4");
		System.out.println("Tente novamente");
	}

}