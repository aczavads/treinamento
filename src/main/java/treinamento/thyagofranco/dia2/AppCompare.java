package treinamento.thyagofranco.dia2;

public class AppCompare {
	
	public static void main(String[] args) {
		String nome1 = "Zuleika";
		String nome2 = "Aaron";
		
		System.out.println(nome1.compareTo(nome2));
		
		nome1 = String.valueOf(nome2);
		
		System.out.println(nome1.compareTo(nome2));
	}
	
	

}
