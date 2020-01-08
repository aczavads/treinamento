package schiavon.gabriel.dia3.patterns.factory;

public enum TiposMyLogger {
	CONSOLE,
	GRAFICO;

	public boolean isConsole() {
		return CONSOLE == this;
	}
	
	public boolean isGrafico() {
		return GRAFICO == this;
	}
}
