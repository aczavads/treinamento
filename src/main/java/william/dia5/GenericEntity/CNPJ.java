package william.dia5.GenericEntity;

import javax.persistence.Embeddable;

import william.silva.dia5.ValidaCpf;

@Embeddable
public class CNPJ {
	private String numCnpj;

	public CNPJ(String numCnpj) {
		if (!ValidaCpf.getInstance().isCNPJ(numCnpj)) {
			throw new RuntimeException("CNPJ informado é inválido!");
		}
		this.numCnpj = numCnpj;
	}
	
	private CNPJ() {
		
	}

	public String getNumCnpj() {
		return numCnpj;
	}

	public void setNumCnpj(String numCnpj) {
		this.numCnpj = numCnpj;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numCnpj == null) ? 0 : numCnpj.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CNPJ other = (CNPJ) obj;
		if (numCnpj == null) {
			if (other.numCnpj != null)
				return false;
		} else if (!numCnpj.equals(other.numCnpj))
			return false;
		return true;
	}
	
	
	
	
}
