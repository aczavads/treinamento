package thyagofranco.dia3.designpatterns.factory;

import javax.swing.JOptionPane;

public class SuperLoggerGrafico implements SuperLogger {

	@Override
	public void log(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
		
	}

}
