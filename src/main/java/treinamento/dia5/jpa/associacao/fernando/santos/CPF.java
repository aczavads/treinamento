package treinamento.dia5.jpa.associacao.fernando.santos;

import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Embeddable
public class CPF {

	private String valor;

	@SuppressWarnings("unused")
	private CPF() {
	}

	public CPF(String valor) {
		String valorSemFormatacao = valor.replaceAll("\\.", "").replaceAll("-", "");
		if (!isCpf(valorSemFormatacao)) {
			throw new RuntimeException("Favor informar um CPF válido.");
		}
		this.valor = valorSemFormatacao;
	}

	public String getValor() {
		return valor;
	}

	private Boolean isCpf(String valor) {
		return CNPValidator.isValidCPF(valor);
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
