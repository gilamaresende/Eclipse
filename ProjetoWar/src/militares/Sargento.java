package militares;

public class Sargento extends Militar{

	public Sargento() {
		super("Sargento");
	}

	@Override
	public int atakk() {
		return super.lancarDado() + 2;//retorna o valor do dados +2
	}
}
