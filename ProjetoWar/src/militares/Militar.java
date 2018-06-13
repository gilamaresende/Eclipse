package militares;

import principal.Dice;

public abstract class Militar{
	private Dice dado;
	private String descricao;

	public Militar (String desc) {
		this.descricao = desc;
		dado = new Dice();
	}
	

	public abstract int atakk();
	
	public String getDescricao() {
		return this.descricao;
	}
	


	public int lancarDado() {
		return this.dado.playDice();
	}
}
