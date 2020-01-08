package treinamento.dia3.fernando.santos.factory;

import java.util.logging.Level;

import javax.swing.JOptionPane;

public class LoggerGrafico implements SuperLogger {

	@Override
	public void log(Level level, String mensagem) {
		if(level.equals(Level.INFO)) {
			JOptionPane.showMessageDialog(null, mensagem);
		} else if(level.equals(Level.WARNING)) {
			JOptionPane.showMessageDialog(null, mensagem);
		}
	}


}
