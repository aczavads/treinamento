package treinamento.dia7.conta_contabil2.fernando.santos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class CodigoDoContaContabilidadeInvalido extends RuntimeException {
	
	public CodigoDoContaContabilidadeInvalido() {
		super("Código do ContaContabilidade está inválido.");
	}

}
