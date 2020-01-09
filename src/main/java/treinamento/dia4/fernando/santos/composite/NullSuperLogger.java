package treinamento.dia4.fernando.santos.composite;

import java.util.logging.Level;

import treinamento.dia3.fernando.santos.factory.SuperLogger;

public class NullSuperLogger implements SuperLogger {

	@Override
	public void log(Level level, String mensagem) {
		System.out.println("(Não faz nada.)");
	}

}
