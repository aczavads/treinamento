package guscam.dia3.factory;

import javax.swing.JOptionPane;

public class MyLoggerGrafico implements MyLogger {

	@Override
	public void log(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

}
