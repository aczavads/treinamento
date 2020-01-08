package schiavon.gabriel.dia3.patterns.factory;

import javax.swing.JOptionPane;

public class LoggerPorGrafico implements MyLogger {

	@Override
	public void log(String log) {
		JOptionPane.showMessageDialog(null, log);
	}

}
