package guscam.dia3.factory;

public class Factory {

	public static void main(String[] args) {
//		MyLogger logger = MyLoggerFactory.createInstance("console");
//		MyLogger logger = MyLoggerFactory.createInstance("grafico"); //grafico
		MyLogger logger = MyLoggerFactory.createInstance("console-grafico"); //console-grafico
		
		logger.log("Mensagem um");
		logger.log("Mensagem dois");

	}

}
