package treinamento.dia3.factory;

import java.util.UUID;

public interface RegistradorDeTransacoes {

	Transacao novaTransa��o(UUID idDaTransacao);

	int getQuantidadeDeTransacoes();

}
