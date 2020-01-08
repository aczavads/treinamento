package treinamento.guilhermeperes.dia3.patterns.factory;

import javax.swing.JOptionPane;

public class PopupLogger implements Logger {

	@Override
	public void log(String text) {
		JOptionPane.showMessageDialog(null, text);
	}
}
