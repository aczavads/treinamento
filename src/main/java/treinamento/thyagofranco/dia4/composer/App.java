package treinamento.thyagofranco.dia4.composer;

import javax.swing.JOptionPane;

import treinamento.thyagofranco.dia3.designpatterns.factory.SuperLogger;
import treinamento.thyagofranco.dia3.designpatterns.factory.SuperLoggerFactory;

public class App {
	
	public static void main(String[] args) {
		
		//console: System.out.println("");
		//gráfico: JOptionPane.showMessageDialog(null, "");
		
		//Exemplos 
		//SuperLogger logger = SuperLoggerFactory.createInstance("console"); 
		//SuperLogger logger = SuperLoggerFactory.createInstance("gráfico"); 
		//SuperLogger logger = SuperLoggerFactory.createInstance("console-com-grafico"); 
		SuperLogger logger = SuperLoggerFactory.createInstance("console-triplo");
		
		
		logger.log("Mensagem importante!");
		logger.log("Outra mensagem");
		
		System.out.println("Fim.");
		
	}

}
