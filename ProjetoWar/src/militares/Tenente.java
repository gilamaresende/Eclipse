package militares;


public class Tenente extends Militar{

		public Tenente() {
			super("Tenente");
		}

		@Override
		public int atakk() {
			return super.lancarDado();
		}

}