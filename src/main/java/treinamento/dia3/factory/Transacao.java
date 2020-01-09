package treinamento.dia3.factory;

public interface Transacao {

	void registrar(String operacao);

	void finalizar();

}
