package fernando_santos.treinamento.dia4.composite;

import java.util.logging.Level;

import fernando_santos.treinamento.dia3.factory.SuperLogger;

public class NullSuperLogger implements SuperLogger {

	@Override
	public void log(Level level, String mensagem) {
		System.out.println("(Não faz nada.)");
	}

}
