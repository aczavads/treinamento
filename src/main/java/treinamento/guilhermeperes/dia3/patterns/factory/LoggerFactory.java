package treinamento.guilhermeperes.dia3.patterns.factory;

import java.util.Optional;

public interface LoggerFactory {
	public static Optional<Logger> createLogger(LoggerType type) {
		switch (type) {
		case CONSOLE:
			return Optional.of(new ConsoleLogger());
			
		case POPUP:
			return Optional.of(new PopupLogger());
			
		default:
			return Optional.empty();
		}
	}
}
