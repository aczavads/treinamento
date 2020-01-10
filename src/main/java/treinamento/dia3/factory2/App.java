package treinamento.dia3.factory2;

import javax.swing.JOptionPane;

public class App {
	
	public static void main(String[] args) {
		
		//console: System.out.println("");
		//gráfico: JOptionPane.showMessageDialog(null, "");
		
		//SuperLogger logger = SuperLoggerFactory.createInstance("console"); 
		//SuperLogger logger = SuperLoggerFactory.createInstance("gráfico"); 
		//SuperLogger logger = SuperLoggerFactory.createInstance("console-com-gráfico"); 
		SuperLogger logger = SuperLoggerFactory.createInstance("console-sei-lá"); 
		
		logger.log("Mensagem importante!");
		logger.log("Outra mensagem");
		
		//System.out.println("\u001B[31m" + "Olha!");
		//System.out.println("\u001B[32m" + "Olha!");
		//System.out.println("\u001B[0m" + "Olha!");
		System.out.println("Fim.");
	}

}
