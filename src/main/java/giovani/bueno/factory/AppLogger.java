package giovani.bueno.factory;

public class AppLogger {

	public static void main(String[] args) {
	
     SuperLogger logger  = SuperLoggerFactory.createInstance("console-triplo");
	 logger.log("TESTEEEEE");

	
	}

}
