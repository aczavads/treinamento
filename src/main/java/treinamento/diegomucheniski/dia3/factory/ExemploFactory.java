package treinamento.diegomucheniski.dia3.factory;

public class ExemploFactory {
	
	public static void main(String[] args) {
		
		// console System.out.println();
		// grafico JOptionPane
		
		// CustomLogger logger = CustomLoggerFactory.createInstance("console");
		// CustomLogger logger = CustomLoggerFactory.createInstance("grafico");
		// CustomLogger logger = CustomLoggerFactory.createInstance("console-triplo");
		CustomLogger logger = CustomLoggerFactory.createInstance("nao-valido");
		logger.log("Mensagem importante");
		logger.log("Outra importante");		
		
	}

}
