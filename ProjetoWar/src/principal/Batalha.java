package principal;

import java.util.ArrayList;
import java.util.Scanner;

import entrada.Teclado;
import militares.Cabo;
import militares.Militar;
import militares.Sargento;
import militares.Soldado;
import militares.Tenente;
import objetos.Jogador;
import objetos.Pais;

public class Batalha {
	Pais atk;
	Pais def;
	
	
	//organizacao do combate
	public void lutar(ArrayList<Pais> paises, Jogador play){
		
		
		escolherParaParaAtk(play.getPaisDeAcao(), play);
		montarAtk();
		escolherAlvo();
		montarDef();
		guerriar();
		
	}
	
	//escolher pais que vai atacar
	public void escolherParaParaAtk(ArrayList<Pais> paises, Jogador play) {
		int op;
		
		play.mostrarPaisesAcao();
		
		op = entrada();
		while(op > paises.size() || op < 1) {
			erroPrint();
			op = entrada();
		}
		atk = paises.get(op-1);
		
	}
	
	//escolhher alvo
	private void escolherAlvo() {
		
		boolean conquistados = false;
		conquistados = atk.mostrarInimigos(atk.getAlvo());
		if(conquistados) {
			escolherParaParaAtk(atk.getDono().getPaisDeAcao(), atk.getDono());
		}
		else {
			int op = entrada();
			
			while ( op < 0 || op > atk.getAlvo().size()) {
				erroPrint();
				op = entrada();
			}
			def = atk.getAlvo().get(op-1);
		}
	}

	//escolher quantos soldados vao ser usados
	private void montarAtk (){
		quatidadesSoldadosParaAtacar(atk);
		int op = entrada();
		
		
		while (op > 3 || op >= atk.getContaSoldado() || op < 1) {
			if(op == 3 && atk.getContaSoldado() == 3 || op == 2 && atk.getContaSoldado() == 2) {
				vigiaPrint();
			}
			else {
				erroPrint();
			}	
			op = entrada();
		}
		treinarMilitar(atk,op);
	}
	
	//escolher quantos soldados vao defender
	private void montarDef() {
		int op;
		quantidadeSoldadosParaDefenfer(def);
		op = entrada();
		
		while (op < 1 || op > 3 || op > def.getContaSoldado()) {
			erroPrint();
			op = entrada();
		}
		escolerSoldados(def);
		treinarMilitar(def, op);
		
		
		
		
	}
	
	//escolher soldados que vao atacar
	private void treinarMilitar(Pais pais, int quant) {
		int op;
		int i = 0;
		int j = 0;
		while(i < quant) {
			pais.mostrarSoldados(quant - j);
			op = entrada();
			while (op < 0 || op > 4) {
				erroPrint();
				op = entrada();
			}
			if(op == 1) {
				if (pais.getSoldado().size() > 0) {
					pais.getMilitarDeGuerra().add(new Soldado());
					i++;
					j++;
				}
				else {
					naoPossivelAdd();
				}
			}
			else if (op == 2) {
				if (pais.getCabo().size() > 0) {
					pais.getMilitarDeGuerra().add(new Cabo());
					i++;
					j++;
				}
				else {
					naoPossivelAdd();
				}
			}
			else if (op == 3) {
				if (pais.getSargento().size() > 0) {
					pais.getMilitarDeGuerra().add(new Sargento());
					i++;
					j++;
				}
				else {
					naoPossivelAdd();
				}
			}
			else {
				if (pais.getTenente().size() > 0) {
					pais.getMilitarDeGuerra().add(new Tenente());
					i++;
					j++;
				}
				else {
					naoPossivelAdd();
				}
			}	
		}
	}
	
	
	//combate
	public void guerriar() {
		int i = 0;
		
		int remover;
		int dadoAtk;
		int dadoDef;
		int opAtk;
		int opDef;
		Militar tmpAtk;
		Militar tmpDef;
		while(i < atk.getMilitarDeGuerra().size() && i < def.getMilitarDeGuerra().size()) {
			soldadoRolarDadosPrint(atk);
			opAtk = entrada();
			
			while (opAtk < 1 || opAtk > atk.getMilitarDeGuerra().size()) {
				erroPrint();
				opAtk = entrada();
			}
			tmpAtk = atk.getMilitarDeGuerra().get(opAtk-1);
			
			soldadoRolarDadosPrint(def);
			opDef = entrada();
			
			while (opDef < 1 || opDef > def.getMilitarDeGuerra().size()) {
				erroPrint();
				opDef = entrada();
			}
			tmpDef = def.getMilitarDeGuerra().get(opDef-1);
			dadoAtk = tmpAtk.lancarDado();
			dadoDef = tmpDef.lancarDado();
			dadosValor(dadoAtk,dadoDef);
			
			
			
			if ( dadoAtk > dadoDef) {
				
				
				quemGanhou(atk.getDono());
				if(def.getContaSoldado() == 1) {
					System.out.println("Jogado_1_1");
					
					remover = def.posicao(def.getDono().getPais(), def);
					System.out.println("Valor   " + remover);
					def.getDono().getPais().remove(remover);
					def.setDono(atk.getDono());
					def.limparAlvo();
					atk.getDono().addPais(def);
					
					if(tmpAtk.getDescricao().equals("Soldado")) {
						def.addSoldado(1);
						atk.rmSoldado();
					}
					else if (tmpAtk.getDescricao().equals("Cabo")) {
						def.addCabo(1);
						atk.rmCabo();
					}
					else if (tmpAtk.getDescricao().equals("Sargento")) {
						def.addSargento(1);
						atk.rmSargento();
					}
					else {
						def.addTenente(1);
						atk.rmTenente();
						
						
					}
				}
				else {
					
					
					
					remover = def.posicao(def.getDono().getPaisDeAcao(), def);
					def.getDono().getPaisDeAcao().remove(remover);
				
				}
				def.rmContaSoldado();
				removerRodada(def, tmpDef,opDef-1);
				removerExercito(def, tmpAtk);
				
			}
			else {
				
				
				quemGanhou(def.getDono());
				
				
				atk.rmContaSoldado();
				removerRodada(atk, tmpAtk,opAtk-1);
				removerExercito(atk, tmpAtk);
				if(atk.getContaSoldado() == 1) {
					
					
					remover = atk.posicao(atk.getDono().getPaisDeAcao(), atk);
					atk.getDono().getPaisDeAcao().remove(remover);
				}
				if(tmpAtk.getDescricao().equals("Soldado")) {
					
					atk.rmSoldado();
				}
				else if (tmpAtk.getDescricao().equals("Cabo")) {
					
					atk.rmCabo();
				}
				else if (tmpAtk.getDescricao().equals("Sargento")) {
					
					atk.rmSargento();
				}
				else {
					
					atk.rmTenente();
					
					
				}
			}
			
			
		i++;
		}
		
		while(atk.getMilitarDeGuerra().size()!=0) {
			atk.getMilitarDeGuerra().remove(0);
		}
		while(def.getMilitarDeGuerra().size()!=0) {
			def.getMilitarDeGuerra().remove(0);
		}
		
		
		
		
	}
	
	//remover soldado que atacou
	public void removerRodada(Pais p, Militar mili,int rm) {
		p.getMilitarDeGuerra().remove(rm);
	}
	
	//remover soldado que perdeu
	private void removerExercito(Pais p, Militar mili) {
		if(mili.getDescricao().equals("Soldado")) {
			
			p.rmSoldado();
			
			
		}
		else if(mili.getDescricao().equals("Cabo")) {
			p.rmCabo();
			
		}
		else if(mili.getDescricao().equals("Sargento")) {
			p.rmSargento();
			
		}
		else if(mili.getDescricao().equals("Tenente")) {
			p.rmTenente();
			
		}
	}
	
	
	
	/////////////////////////
	// prints na tela
	private void escolerSoldados(Pais p) {
		
		System.out.println("Jogador " + p.getDono().getCor() +" escolha seus Militares" );
	}
	
	private void dadosValor(int atk, int def) {
		System.out.println("Dado de Ataque " + atk);
		System.out.println("Dado de Defesa " + def);
	}
	
	private void quemGanhou(Jogador j) {
		System.out.println(j.getCor() + " Ganhou");
	}
	
	private void soldadoRolarDadosPrint(Pais p) {
		System.out.println("Jogador " + p.getDono().getCor() + " selecione seu campeao para esta rodada");
		int i = 1;
		
		for(Militar m : p.getMilitarDeGuerra()) {
			
			System.out.println(i + " - " + m.getDescricao());
			i++;
		}
	}
	
	private void naoPossivelAdd() {
		System.out.println("Nao foi possivel adicionar este soldado, verifique a quantidade disponivel");
	}
	
	private void quantidadeSoldadosParaDefenfer(Pais p) {
		System.out.println("Jogador " + p.getDono().getCor() + " Com quantos Militares deseja se defender");
	}
	
	public void vigiaPrint() {
		System.out.println("Um soldado tem que vigiar o Pais,\nTente Novamente");
	}
	
	public void erroPrint() {
		System.out.println("Opção Invalida,\nTente novamente");
	}
	
	public void quatidadesSoldadosParaAtacar(Pais p) {
		System.out.println(p.getDono().getCor() + " Com quandos militares deseja atacar:");
	}
	
	public int entrada() {
		Teclado tc = new Teclado();
		return tc.teclado();
	}
	
	
}


