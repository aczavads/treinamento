package fernando_santos.treinamento.dia3.factory;

import java.util.logging.Level;

public class LoggerConsole implements SuperLogger {

	@Override
	public void log(Level level, String mensagem) {
		if(level.equals(Level.INFO)) {
			System.out.println("\u001B[31m" + mensagem);
		} else if(level.equals(Level.WARNING)) {
			System.out.println("\u001B[34m" + mensagem);
		}
	}

}
