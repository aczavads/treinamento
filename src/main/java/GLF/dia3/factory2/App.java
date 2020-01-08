package GLF.dia3.factory2;



public class App {

	public static void main(String[] args) {
		//console: System.out.println("");
		//grafico:JOptionPane.showMessageDialog(null,"");
		
		SuperLogger logger = SuperLoggerFactory.createInstance("console"); //grafico
		
		logger.log("...");
		logger.log("...");
	}
}
