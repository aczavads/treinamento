package treinamento.dia5.jpa.associacao.fernando.santos;

import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Embeddable
public class CNPJ {

	private String valor;

	@SuppressWarnings("unused")
	private CNPJ() {
	}

	public CNPJ(String valor) {
		String valorSemFormatacao = valor.replaceAll("\\.", "").replaceAll("-", "");
		if (!isCnpj(valorSemFormatacao)) {
			throw new RuntimeException("Favor informar um CNPJ válido.");
		}
		this.valor = valorSemFormatacao;
	}

	public String getValor() {
		return valor;
	}

	private boolean isCnpj(String valor) {
		return CNPValidator.isValidCNPJ(valor);
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
