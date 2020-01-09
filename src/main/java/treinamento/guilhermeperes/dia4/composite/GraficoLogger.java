package treinamento.guilhermeperes.dia4.composite;

import treinamento.guilhermeperes.dia3.patterns.factory.Logger;

public class GraficoLogger implements Logger {

	@Override
	public void log(String text) {
		System.out.println("Logger Gráfico: " + text);
	}
}
