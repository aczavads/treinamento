package william.dia5;

import javax.persistence.Embeddable;

@Embeddable
public class CPF {
	private String numCpf;
	
	private CPF() {
		
	}

	public CPF(String numCpf) {
		if (!ValidaCpf.getInstance().isCPF(numCpf)) {
			throw new RuntimeException("CPF informado é inválido!");
		}
		this.numCpf = numCpf;
	}
	
	
	
}
