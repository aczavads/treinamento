package GLF.dia3.factory2;



public class App {

	public static void main(String[] args) {
		//console: System.out.println("");
		//grafico:JOptionPane.showMessageDialog(null,"");
		
		//SuperLogger logger = SuperLoggerFactory.createInstance("grafico"); //grafico
		
		//SuperLogger logger = SuperLoggerFactory.createInstance("console-com-grafico");
		
		SuperLogger logger = SuperLoggerFactory.createInstance("console-triplo");
		
		logger.log("teste");
		logger.log("...");
	}
}
