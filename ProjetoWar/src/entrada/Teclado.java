package entrada;

import java.util.Scanner;

public class Teclado {

	private Scanner sc;

	public int teclado() {
		int r;
		sc = new Scanner(System.in);
		r = sc.nextInt();
		return r;
	}
}


