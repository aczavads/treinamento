package thais.matera.dia3.factory;

import javax.swing.JOptionPane;

public class ConsoleLogger implements Logger {
	public void log(String message) {
		System.out.println(message);
	}
}
