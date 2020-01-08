package treinamento.dia3.factory;

import java.util.UUID;

public class RegistradorDeTransacoesPorLog implements RegistradorDeTransacoes {
	private int quantidade = 0;

	@Override
	public Transacao novaTransação(UUID idDaTransacao) {
		quantidade++;
		return new TransacaoPorLog(idDaTransacao);
	}

	@Override
	public int getQuantidadeDeTransacoes() {
		return quantidade;
	}

}
