package thais.matera.dia3.factory;

import javax.swing.JOptionPane;

public class GraphicLogger implements Logger {
	public void log(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
}
