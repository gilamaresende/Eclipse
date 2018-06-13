package principal;

import java.util.Random;
/**
 * 
 * @author gilmar.resende
 *
 */
public class Dice{
    Random dice;//dados
    
    /**
     * Retorna um inteiro aleatorios que os jogadores e soldados precisa.
     */
    public Dice(){
        
        dice = new Random();
        
    }
    
    /**
     * @return Retorna um inteiro de 0 a 6 
     */
    public int playDice(){ 
    	
        return dice.nextInt(6) + 1; 
    }
    /**
     * Retorna um numero aleatorio entre 0 e o valor recebido
     * @param Recebe um inteiro
     * @return Retorna um inteiro
     */

    public int playsorte(int max) {
    	return dice.nextInt(max);
    }
}