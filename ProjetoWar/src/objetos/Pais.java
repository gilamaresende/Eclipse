package objetos;

import java.util.ArrayList;


import militares.Cabo;
import militares.Militar;
import militares.Sargento;
import militares.Soldado;
import militares.Tenente;


public class Pais {
	
	private int contaSoldado = 0;
	
	private String nome;
	
	private Jogador dono;
	
	private ArrayList <Pais> vizinhos;
	private ArrayList <Pais> alvo;
	private ArrayList <Pais> migrar;
	
	private ArrayList<Soldado> soldado;
	private ArrayList<Cabo> cabo;
	private ArrayList<Sargento> sargento;
	private ArrayList<Tenente> tenente;
	private ArrayList<Militar> militarDeGuerra;

	public Pais(String nome) {
		this.nome = nome;
		this.militarDeGuerra = new ArrayList<Militar>();
		this.vizinhos = new ArrayList<Pais>();
		this.sargento = new ArrayList<Sargento>();
		this.soldado =  new ArrayList<Soldado>(); 
		this.cabo =  new ArrayList<Cabo>();
		this.tenente =  new ArrayList<Tenente>();
		this.alvo = new ArrayList<Pais>();
		this. migrar = new ArrayList<Pais>();
		
		
	}
	
	//retorna posicao de objeto em uma lista
	public int posicao(ArrayList<Pais> lista, Pais pais) {
		int i = 0;
		for (Pais p : lista) {
			if(p == pais) {
				break;
				
			}
			else {
				i++;
			}
		}
		System.out.println("Teste   " + i);
		return i;
	}
	
	
	
	
	//Add
	public void addVizinho(Pais p) {
		this.vizinhos.add(p);
	}
	
	public void addSoldado(int q) {
		for (int i = 0; i < q; i++) {
			this.soldado.add(new Soldado());
			contaSoldado++;;
		}		
	}
	
	public void addCabo(int q) {
		for (int i = 0; i < q; i++) {
			this.cabo.add(new Cabo());
			contaSoldado++;;
		}		
	}
	
	public void addSargento(int q) {
		for (int i = 0; i < q; i++) {
			this.sargento.add(new Sargento());
			contaSoldado++;
		}		
	}
	
	public void addTenente(int q) {
		for (int i = 0; i < q; i++) {
			this.tenente.add(new Tenente());
			contaSoldado++;
		}		
	}
	
	//Add Modo Combate
	
	public void addAlvo(Pais p) {
		this.alvo.add(p);
	}
	
	public void addmigrar(Pais p) {
		this.migrar.add(p);
	}
	
	//Remove
	public void rmSoldado() {
		this.soldado.remove(0);
	}
	
	public void rmCabo() {
		this.cabo.remove(0);
	}
	
	public void rmSargento() {
		this.sargento.remove(0);
	}
	
	public void rmTenente() {
		this.tenente.remove(0);
	}
	
	//Remover Modo Combate
	
	public void rmAlvo() {
		this.alvo.remove(0);
	}
	
	public void rmMigrar() {
		this.migrar.remove(0);
	}
	
	
	//Sets
	public void rmContaSoldado() {
		this.contaSoldado--;
	}
	
	public void setDono(Jogador play) {
		this.dono = play;
	}
	
	public ArrayList<Soldado> getSoldado(){
		return this.soldado;
	}
	
	public ArrayList<Cabo> getCabo(){
		return this.cabo;
	}
	
	public ArrayList<Sargento> getSargento(){
		return this.sargento;
	}
	
	public ArrayList<Tenente> getTenente(){
		return this.tenente;
	}


	//Gets
	public ArrayList<Militar> getMilitarDeGuerra(){
		return militarDeGuerra;
	}
	
	public int getContaSoldado() {
		return contaSoldado;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public ArrayList<Pais> getVizinhos(){
		return this.vizinhos;
	}
	
	public ArrayList<Pais> getAlvo(){
		return this.alvo;
	}
	
	public Jogador getDono() {
		return this.dono;
	}
	
	public ArrayList<Pais> getMigrar() {
		return this.migrar;
	}
	
	public ArrayList<Militar> getSoldadoDeGuerra(){
		return this.getMilitarDeGuerra();
	}
	
	
	//print todos paises
	public void mostrarSoldados(int i) {
		
		System.out.println("Escolhar seus soldados para atacar");
		System.out.println("Confirme 1 soldado por vez");
		System.out.println("-------------------------------------");
		System.out.println(this.getNome() + "\n");
		System.out.println("1 - Soldados - quantidade: " + getSoldado().size());
		System.out.println("2 - Cabo - quantidade: " + getCabo().size());
		System.out.println("3 - Sargento  quantidade: " + getSargento().size());
		System.out.println("4 - Tenente - quantidade: " + getTenente().size());
		System.out.println("-------------------------------------");
		System.out.println("\nRestao " + i + " para selecionar:");
	}
	public void mostrarPaises(Pais p, int i) {
		
		
		System.out.println(i + " - " + p.nome + " possui " + p.getContaSoldado());
		
			
	}
	
	

	//definir quem é amigo e inimigo
	public void setAlvoMigrar() {

		for(Pais p : vizinhos) {

			if (this.dono == p.dono) {
				
				migrar.add(p);
				
				
			}
			else {
				
				alvo.add(p);
			}
		}		
	}
	
	//limpa todos os alvos
	public void limparAlvo() {
	
		while(alvo.size() != 0) {
			alvo.remove(0);
		}
		while ( migrar.size() != 0){
			migrar.remove(0);
		}
		
		setAlvoMigrar();
	}
	
	//mostar se conquistou todos os vizinhos de um pais caso nao mostrar os inimigos
	public boolean mostrarInimigos(ArrayList<Pais> alvo) {
		int i = 1;
		if(alvo.size()!=0) {
			System.out.println("Selecione o alvo ");
			for(Pais p : alvo) {
				System.out.println(i + " - " + p.getNome() + " possui " + p.getContaSoldado() + " Militares");
				i++;
			}
			return false;
		}
		else {
			System.out.println("Todos os vizinhos deste pais sao seus");
			return true;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
