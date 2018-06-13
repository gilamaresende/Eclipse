package objetos;



public class Conquitar15Pais implements Objetivo{
	int quantidadePaises = 15;
	Jogador playVencedor;
	@Override
	public boolean ifConcluido(Jogador p) {
		if(p.getPais().size() == quantidadePaises) {
			playVencedor = p;
			return true;
		}
		return false;
		
	}
	
	public Jogador getVencedor() {
		return playVencedor;
	}
	

	

}
