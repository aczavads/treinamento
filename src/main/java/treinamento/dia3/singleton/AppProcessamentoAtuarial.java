package treinamento.dia3.singleton;

public class AppProcessamentoAtuarial {

	
	public static void main(String[] args) {
		ProcessamentoAtuarial processa = new ProcessamentoAtuarial(Universo.getInstance());
		processa.processarContratoDoCliente("10");
	}
}
