package principal;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;

import entrada.Teclado;
import militares.Militar;
import objetos.Pais;

public class Movimento {
	Pais saida;
	Pais terraNova;
	Militar militar;
	
	public void movimente(ArrayList<Pais> lista) {
		int op;
		
		int op2;
	
		
	
	
		
		
		mostrarLista(lista);
		op = entrada();
		saida = lista.get(op-1);
		
		mostrarMilitar(saida);
		op2 = entrada();
		
		while(op < 0 || op > 4){
			erroPrint();
			op2= entrada();
		}
		
		
		saida.getContaSoldado();
		mostrarVizinhosAminhos(saida.getMigrar());
		op2 = entrada();
		while(op2 < 1 || op2 > saida.getMigrar().size()) {
			erroPrint();
			op2 = entrada();
		}
		terraNova = lista.get(op-1).getMigrar().get(op2-1);
		
		
		saida.rmContaSoldado();
		if (op2 == 1  || saida.getSoldado().size() > 0) {
			
			saida.rmSoldado();
			
			
			terraNova.addSoldado(1);
			
		}
			
		else if (op2 == 2 || saida.getCabo().size() > 0) {
			saida.rmCabo();
			terraNova.addCabo(1);
		}
			
		else if (op2 == 3 || saida.getSargento().size() > 0) {
			saida.rmSargento();
			terraNova.addSargento(1);
		}
			
		else if (op2 == 4 || saida.getTenente().size() > 0){
			saida.rmTenente();
			terraNova.addTenente(1);
		}
		else {
			erroPrint();
		}
		
		System.out.println(saida.getNome() + " antes " + saida.getContaSoldado());
		
		System.out.println(saida.getNome() + " depois " + saida.getContaSoldado());
		System.out.println(terraNova.getNome() + " antes " + terraNova.getContaSoldado());
		
		System.out.println(terraNova.getNome() + " depois " + terraNova.getContaSoldado());
	
		boolean jaPertence = false;
		
		for(Pais p : saida.getDono().getPaisDeAcao()) {
			if (p == terraNova) {
				jaPertence = true;
				break;
			}
			else {
				jaPertence = false;
			}
		}
		if(!jaPertence) {
			terraNova.getDono().getPaisDeAcao().add(terraNova);
			
		}
		int pos;
		if (saida.getContaSoldado() == 1) {
			pos = saida.posicao(lista, saida);
			saida.getDono().getPaisDeAcao().remove(pos);
		}
	}
		
	
	//mostrar paises que tem e quais soldados podem ser movidos
	private void mostrarMilitar(Pais p) {
		System.out.println("Selecione o tipo que deseja mover:\n");
		System.out.println("------------------------------------------");
	
		System.out.println("1 - Soldados - quantidade: " + p.getSoldado().size());
		System.out.println("2 - Cabo - quantidade: " + p.getCabo().size());
		System.out.println("3 - Sargento  quantidade: " + p.getSargento().size());
		System.out.println("4 - Tenente - quantidade: " + p.getTenente().size());
		System.out.println("------------------------------------------");
	}
	//mostrar paises para onde pode mover soldados
	private void mostrarVizinhosAminhos(ArrayList<Pais> pais) {
		System.out.println("\n\nSelecione o pais para onde deseja mover os exercitos");
		System.out.println("----------------------------------------");
		
		int i = 1;
		
		
	
		for (Pais p : pais) {
			System.out.println(i + " - " + p.getNome() + " - " + p.getContaSoldado() + " Militares");
			i++;
		}
		System.out.println("----------------------------------------");
		
		
		
		
	}
	
	
	public void mostrarLista(ArrayList<Pais> pais) {
		System.out.println("\n\nSelecione o pais que deseja mover exercitos");
		System.out.println("----------------------------------------");
		
		int i = 1;
		for (Pais p : pais) {
			System.out.println(i + " - " + p.getNome() + " - " + p.getContaSoldado() + " Militares");
			i++;
		}
		System.out.println("----------------------------------------");
		
	}
	
	private void erroPrint() {
		System.out.print("Opcao incorreta,\n Tente novamente");
	}
	
	public int entrada() {
		Teclado tc = new Teclado();
		return tc.teclado();
	}

	
}
