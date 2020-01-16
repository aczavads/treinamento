package fernando_santos.treinamento.dia8.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class CodigoDoContaContabilidadeInvalido extends RuntimeException {
	
	public CodigoDoContaContabilidadeInvalido() {
		super("Código do ContaContabilidade está inválido.");
	}

}
