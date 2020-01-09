package treinamento.matheus.faxina;

public class Factory {
	
	public static void main(String[] args) {
		Loggerr logger = LoggerFactory.createInstance("lalala"); //grafico, console e console-com-grafico
		
		logger.log("testando");
	}

}
