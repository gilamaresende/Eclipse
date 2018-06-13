package objetos;

import java.util.ArrayList;

import objetos.Pais;

public class Continente {
	ArrayList <Pais> paises;
	String nome;
	
	
	public Continente() {
		paises = new ArrayList<Pais>();
	}

	//set nome do continente
	public void setNome(String nome) {
		this.nome = nome;
	}
	//adiciona pais no continete usado na criação
	public void addPaisNoContinente(Pais p) {
		this.paises.add(p);
	}
	//retorna os paises
	public ArrayList<Pais> getPaises(){
		return this.paises;
	}
	//retorna o nome
	public String getNome() {
		return this.nome;
	}
}
