package treinamento.thyagofranco.dia3.designpatterns.factory;


public class App {
	
	public static void main(String[] args) {
		
		//console: System.out.println...
		//grafico: JOptionPane.showMessageDialog(null, "");
		
		SuperLogger logger = SuperLoggerFactory.createInstance("grafico"); //gr�fico
		
		logger.log("Mensagem importante!");
		logger.log("Outra mensagem");
		
		
	}

}

//Ao trocar o hit de console ou gr�fico , logger deve imprimir no console ou mostrar um JPainel.


// criar interface SuperLogger 1 metodo log(String)
// LoggerFactory tem 1 metodo est�tico createInstance("") console ou gr�fico
//