package militares;


public class Cabo extends Militar{

	public Cabo () {
		super("Cabo");
	}

	@Override
	public int atakk() {
		return super.lancarDado() + 1;
	}


}
