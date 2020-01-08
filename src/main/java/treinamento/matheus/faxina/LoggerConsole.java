package treinamento.matheus.faxina;

import javax.swing.JOptionPane;

public class LoggerConsole implements Loggerr {

	@Override
	public void log(String string) {
		JOptionPane.showMessageDialog(null, string);
	}

}
