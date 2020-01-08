package treinamento.diegomucheniski.dia3.factory;

import javax.swing.JOptionPane;

public class CustomLoggerGrafico implements CustomLogger {

	@Override
	public void log(String texto) {
		JOptionPane.showMessageDialog(null, texto);
	}

}
