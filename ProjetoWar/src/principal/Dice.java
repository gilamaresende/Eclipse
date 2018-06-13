package principal;

import java.util.Random;

public class Dice{
    Random dice;//dados
    
    public Dice(){
        
        dice = new Random();
        
    }
    //retorna um numero aleatorio de 1 a 6
    public int playDice(){ 
    	
        return dice.nextInt(6) + 1; 
    }
    /**
     * 
     * @param Recebe um inteiro que o valor maximo que pode ser retornado
     * @return Retorna um inteiro entre 0 e o valor passado como parametro
     */
    
    //retorna um numeor aleatorio de 0 ate o valor pedido
    public int playsorte(int max) {
    	return dice.nextInt(max);
    }
}