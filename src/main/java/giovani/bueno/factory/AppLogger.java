package giovani.bueno.factory;

public class AppLogger {

	public static void main(String[] args) {
	
     SuperLogger logger  = SuperLoggerFactory.createInstance("grafico");
	 logger.log("TESTEEEEE");
	 
	 logger.log("TESTEEEEsadadE");
	
	}

}
