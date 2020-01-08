package treinamento.dia3.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.swing.JOptionPane;

public class TransacaoPorPopup implements Transacao {
	private List<String> operacoes = new ArrayList<String>();
	private UUID id;
	
	public TransacaoPorPopup(UUID idDaTransacao) {
		this.id = idDaTransacao;
	}

	@Override
	public void registrar(String operacao) {
		operacoes.add(operacao);
	}

	@Override
	public void finalizar() {
		JOptionPane.showMessageDialog(null, "Transação finalizada " + id);
	}
}
