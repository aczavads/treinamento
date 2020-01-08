package schiavon.gabriel.dia3.patterns.factory;

public class AppLogger {

	public static void main(String[] args) {
//		console: System.out.println("");
//		grafico: JOptionPane.showMessageDialog(null, "");
		MyLogger logger = MyLoggerFactory.createInstance(TiposMyLogger.GRAFICO);
		
		logger.log("Mensagem importante!");
		logger.log("Outra mensagem");
	}
	
}
