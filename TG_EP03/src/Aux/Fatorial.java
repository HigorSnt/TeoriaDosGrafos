package Aux;

/**
 * 
 * Classe feita para auxiliar ao cálculo fatorial utilizado em Scores.
 * 
 * @author HIGOR SANTOS DE BRITO DANTAS
 * @author GABRIEL CARVALHO DE LIMA
 * @author MATHEUS HENRIQUE FERNANDES JUSTINO
 *
 */

public class Fatorial {
	
	public static long factorial (int n) {
    	if (n == 1 || n == 0) {
    		return 1;
    	} else {
    		return n * factorial(n-1);
    	}
    }
}
