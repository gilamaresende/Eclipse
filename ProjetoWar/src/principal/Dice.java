package principal;

import java.util.Random;

public class Dice{
    Random dice;//dados
    /**
    *Dado usado na batalha
    *
    */
    public Dice(){
        
        dice = new Random();
        
    }
    //retorna um numero aleatorio de 1 a 6
    public int playDice(){ 
    	
        return dice.nextInt(6) + 1; 
    }
    //retorna um numeor aleatorio de 0 ate o valor pedido
    public int playsorte(int max) {
    	return dice.nextInt(max);
    }
}
