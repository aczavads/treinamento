package treinamento.dia5.jpa.fernando.santos;

public class CPF {

	private String valor;

	@SuppressWarnings("unused")
	private CPF() {
	}

	public CPF(String valor) {
		String valorSemFormatacao = valor.replaceAll("\\.", "").replaceAll("-", "");
		if (!isCpf(valorSemFormatacao)) {
			throw new RuntimeException("Favor informar um CPF v�lido.");
		}
		this.valor = valorSemFormatacao;
	}

	public String getValor() {
		return valor;
	}

	private Boolean isCpf(String valor) {
		return CNPValidator.isValidCPF(valor);
	}

}
