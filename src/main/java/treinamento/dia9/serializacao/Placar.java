package treinamento.dia9.serializacao;

import java.io.Serializable;

public class Placar implements Serializable {
	private static final long serialVersionUID = -6552026931165626599L;
	private int pontuacao;
	private int ultimaPontuacao;

	public Placar(int pontuacaoInicial) {
		this.pontuacao = pontuacaoInicial;
	}
	public void pontuar(int pontos) {
		this.pontuacao += pontos;
		this.ultimaPontuacao = pontos;
	}
	public int getPontuacao() {
		return pontuacao;
	}
	public int getUltimaPontuacao() {
		return ultimaPontuacao;
	}

}
