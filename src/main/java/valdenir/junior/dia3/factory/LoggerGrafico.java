package valdenir.junior.dia3.factory;

import javax.swing.JOptionPane;

public class LoggerGrafico implements Logger {

	@Override
	public void log(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}

}
