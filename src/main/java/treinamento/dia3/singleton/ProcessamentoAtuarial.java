package treinamento.dia3.singleton;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProcessamentoAtuarial {
	private Universo universo;
	
	public ProcessamentoAtuarial(Universo universo) {
		super();
		this.universo = universo;
	}

	public void processarContratoDoCliente(String idDoCliente) {
		List<BigDecimal> valores = recuperarValoresPedentes(idDoCliente);
		for (BigDecimal bigDecimal : valores) {
			
		}
		//Universo.getInstance().expandir();
		this.universo.expandir();
	}

	private List<BigDecimal> recuperarValoresPedentes(String idDoCliente) {
		return new ArrayList<BigDecimal>();
	}

}
