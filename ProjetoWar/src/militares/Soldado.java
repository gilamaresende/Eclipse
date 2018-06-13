package militares;


public class Soldado extends Militar{

	public Soldado() {
		super("Soldado");
	}

	@Override
	public int atakk() {
		return super.lancarDado();
	}


}
