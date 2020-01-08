package treinamento.matheus.faxina;

public class Factory {
	
	public static void main(String[] args) {
		Loggerr logger = LoggerFactory.createInstance("grafico"); //grafico
		
		logger.log("testando");
	}

}
