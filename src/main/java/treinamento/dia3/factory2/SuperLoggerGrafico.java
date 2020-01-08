package treinamento.dia3.factory2;

import javax.swing.JOptionPane;

public class SuperLoggerGrafico implements SuperLogger {

	@Override
	public void log(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}

}
