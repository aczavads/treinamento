package treinamento.dia3.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TransacaoPorLog implements Transacao {
	private List<String> operacoes = new ArrayList<String>();
	private UUID id;
	
	public TransacaoPorLog(UUID idDaTransacao) {
		this.id = idDaTransacao;
	}

	@Override
	public void registrar(String operacao) {
		operacoes.add(operacao);
	}

	@Override
	public void finalizar() {
		System.out.println("Finalizando transação " + id);
	}

}
