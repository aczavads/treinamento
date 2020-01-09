package treinamento.dia3.factory;

import java.util.UUID;

public interface RegistradorDeTransacoes {

	Transacao novaTransação(UUID idDaTransacao);

	int getQuantidadeDeTransacoes();

}
