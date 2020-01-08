package william.silva.dia3.Factory;

import javax.swing.JOptionPane;

public class LoggerGrafico implements Logger {

	@Override
	public void log(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
		
	}
	

}
