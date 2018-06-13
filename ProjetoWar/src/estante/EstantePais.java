package estante;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import entrada.ArquivosPais;
import objetos.Continente;
import objetos.Pais;
import principal.Dice;

import objetos.Jogador;;

public class EstantePais {
	private ArrayList <Pais> paises;
	private ArrayList <Continente> mundo;
	
	public EstantePais() throws FileNotFoundException {
		paises = new ArrayList<Pais>();
		mundo = new ArrayList<Continente>();
		
		this.criarPaises();
	}
	
	
	//ler arquivo com os paises
	private void criarPaises() throws FileNotFoundException {
		
		ArquivosPais leitura = new ArquivosPais();
		
		leitura.ler(paises, mundo);
		
		
	}
	
	//distribui os paises entre os jogadores
	public void distribuirPaises(ArrayList<Jogador> play) {
		ArrayList<Pais> paisesCopia = new ArrayList<Pais>();
		Dice dado = new Dice();
		int n;
		
		for (Pais p : paises) {
			paisesCopia.add(p);
		}
		
		for (Pais p : paisesCopia) {
			n = dado.playsorte(paisesCopia.size());
			
			
		}
		
		
		
		
		while (paisesCopia.size() != 0) {
			
			for (Jogador j : play) {
				n = dado.playsorte(paisesCopia.size());
				
				j.addPais(paisesCopia.get(n));
				paisesCopia.get(n).addSoldado(1);
				paisesCopia.get(n).setDono(j);
				paisesCopia.remove(n);
			}
		}
		
	}
	//retorna todos continetes
	public ArrayList<Continente> getMundo(){
		return mundo;
	}
	
	//organiza quais vizinhos sao amigos e inimigos
	public void distribuirVizinhos() {
		for(Pais p : paises) {
			
			p.limparAlvo();
		}
	}
	
	
	



	
}
