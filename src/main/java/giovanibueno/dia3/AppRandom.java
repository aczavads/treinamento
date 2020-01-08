package giovanibueno.dia3;

public class AppRandom {

	
	public static void main(String args[]) {
		
		// Gerar os 5 números aleatórios e mostrá-los:
	     for (int i = 0; i < 5; i++) {
	        int numAleatorio = (int)(Math.random() * 10 ) + 100;
	        System.out.println("Número: " + numAleatorio);
	     }
		
	}
}
