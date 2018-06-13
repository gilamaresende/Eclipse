package principal;

import estante.EstantePais;

import java.io.FileNotFoundException;

import estante.EstanteJogador;

public class Mapa {
	private EstanteJogador play;
	private EstantePais paises;
	private Rodada rodadas;
	private boolean vitoria;
	
	
	public Mapa() throws FileNotFoundException {
		vitoria = false;
		paises = new EstantePais();
		play = new EstanteJogador();
		
		rodadas = new Rodada();
		
		
	}
	
	public void iniciar() {
		
		//sortear objetivo
		
		play.ordenaAtk();
		paises.distribuirPaises(play.getPlayes());
		
		paises.distribuirVizinhos();
	
		
		while (!vitoria) {
			rodadas.nRodadas();
			rodadas.adicionarExercito(play.getOrdem());
			rodadas.bonus(play.getOrdem(), paises.getMundo());
			rodadas.acoes(play.getOrdem());
			vitoria = rodadas.verificarVencedor(play.getPlayes());
		}
		
		rodadas.fimDeJogo();
		
		
		
		
	}
	
	
}
