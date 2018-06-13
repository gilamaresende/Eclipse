package objetos;

import java.util.ArrayList;
import entrada.Teclado;
import militares.Militar;
import principal.Batalha;
import principal.Movimento;




public class Jogador {
	
	private String cor;
	
	private boolean vida;
	
	private ArrayList <Pais> pais;
	private ArrayList <Pais> paisDeAcao;
	private Objetivo obj;

	

	
	
	public Jogador(ArrayList<String> cores) {
		Objetivo obj = new Conquitar15Pais();
		vida = true;
		pais = new ArrayList<Pais>();
	    paisDeAcao = new ArrayList<Pais>();
		
		this.escolherCor(cores);
		
		
	}
	
	
	//escolher cor do jogador
	private void escolherCor(ArrayList<String> cores) {
		int i = 1;
		for (String color : cores) {
			this.corP(i, color);
			i++;
		}
		
		i = entrada();
		
		while(i < 1 || i > cores.size()) {
			this.opcaoIncorreta();
			i = entrada();
		}
		
		this.cor = cores.get(i-1);
		cores.remove(i-1);
	}
	
	
	//mover Exercitos
	public void mover() {
		Movimento mexida = new Movimento();
		mexida.movimente(getPaisDeAcao());
	}
	
	
	//declarar atk
	public void atk() {
		Batalha luta = new Batalha();
		selecionePaisParaAtk();
		//mostrarPaisesAcao();
		
		luta.lutar(getPaisDeAcao(),paisDeAcao.get(0).getDono());
		
		
	}
	
	
	//mostrar paises do jogador
	public void mostrarPaises(){
		int qTotal;
		int i = 1;
		System.out.println("------------------------------\n");
		for (Pais p : pais ) {
			qTotal = p.getSargento().size() + p.getSoldado().size() + p.getTenente().size() + p.getCabo().size();
			System.out.println(i + " - " + p.getNome() + " - " + qTotal);
			i++;
		}
		System.out.println("\n------------------------------");
	}
	
	public void mostrarPaisesAcao(){
		int qTotal;
		int i = 1;
		System.out.println("------------------------------\n");
		for (Pais p : getPaisDeAcao() ) {
			qTotal = p.getSargento().size() + p.getSoldado().size() + p.getTenente().size() + p.getCabo().size();
			System.out.println(i + " - " + p.getNome() + " - " + qTotal);
			i++;
		}
		System.out.println("\n------------------------------");
	}
	
	public void addNaListaDeAcao(Pais pais) {
		boolean jaPertence = false;
		for(Pais p : paisDeAcao) {
			if (p == pais) {
				jaPertence = true;
				break;
			}
			else {
				jaPertence = false;
			}
		}
		if(!jaPertence) {
			paisDeAcao.add(pais);
		}
		
		
	}
	
	
	
	//Add
	
	public void addBonus(Militar m) {
		int op;
		mostrarPaises();
		System.out.println("selecione qual pais deseja adicionar um " + m.getDescricao());
		op = entrada();
		
		while(op < 1 || op > pais.size()) {
			op = entrada();
		}
		if(m.getDescricao().equals("Soldado")) {
			pais.get(op-1).addSoldado(1);
			
		}
		else if(m.getDescricao().equals("Cabo")) {
			pais.get(op-1).addCabo(1);
		}
		
		else if(m.getDescricao().equals("Sargento")) {
			pais.get(op-1).addSargento(1);
		}
		else {
			pais.get(op-1).addTenente(1);
		}
		
		pais.get(op-1).getDono().addNaListaDeAcao(pais.get(op-1));
		
		
		
	}
	
	//adicionar militar no inicio da rodada
	public void addMilitar() {
		int op;
		int quantidadeParaAdd = pais.size()/2;
		Pais tmpPais;
		boolean jaPertence ;
		
		while(quantidadeParaAdd != 0) {
			jaPertence = false;
			this.quantidadeExercitoAdd(quantidadeParaAdd);
			mostrarPaises();
			this.emQualAdd();
			op = entrada();
			while(op > pais.size()) {
				opcaoIncorreta();
				op = entrada();
			}
			tmpPais = pais.get(op-1);
			this.quantidadeExercitoAdd(quantidadeParaAdd);
			op = entrada();
			while(op > quantidadeParaAdd) {
				opcaoIncorreta();
				op = entrada();
			}
			
			tmpPais.addSoldado(op);
			for(Pais p : paisDeAcao) {
				if (p == tmpPais) {
					jaPertence = true;
					break;
				}
				else {
					jaPertence = false;
				}
			}
			if(!jaPertence) {
				paisDeAcao.add(tmpPais);
			}
			
			quantidadeParaAdd =  quantidadeParaAdd-op;
			
		}	
	}
	
	
	
	public void addPais(Pais p) {
		pais.add(p);
	}
	
	public void addPaisAcao(Pais p) {
		paisDeAcao.add(p);
	}
	
	
	//Gets
	
	public Objetivo getObjetivo() {
		return obj;
	}
	
	public String getCor() {
		return this.cor;
	}
	
	public ArrayList<Pais> getPais(){
		return pais;
	}
	
	public ArrayList<Pais> getPaisDeAcao(){
		return paisDeAcao;
	}
	
	public boolean getVida() {
		return vida;
	}
	
	
	//Prints
	private void corP(int i, String cor) {
		System.out.println(i + " - " + cor);
	}
	
	private void opcaoIncorreta() {
		System.out.print("Opcao incorreta,\n Tente novamente");
	}
	
	private void quantidadeExercitoAdd(int q) {
		System.out.println("Jogador " + this.getCor() + " pode adicionar ate " + q + " Exercitos");
	}
	
	
	private void emQualAdd() {
		System.out.println("Em qual pais deseja adicionar os militares:");
	}
	
	private void selecionePaisParaAtk() {
		System.out.println("Selecione o pais com que deseja atakar");
	}
	
	
	//Entrada Teclado
	private int entrada() {
		Teclado tcl = new Teclado();
		return tcl.teclado();
	}
	

	


	
}

