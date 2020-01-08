package thais.matera.dia3.factory;

import javax.swing.JOptionPane;

public class ConsoleLogger implements Logger {
	
	@Override
	public void log(String message) {
		System.out.println(message);
	}
}
