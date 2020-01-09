package treinamento.dia3.factory;

import java.util.UUID;

public class RegistradorDeTransacoesPorPopup implements RegistradorDeTransacoes {
	private int quantidade = 0;

	@Override
	public Transacao novaTransação(UUID idDaTransacao) {
		quantidade++;
		return new TransacaoPorPopup(idDaTransacao);
	}

	@Override
	public int getQuantidadeDeTransacoes() {
		return quantidade;
	}
}
