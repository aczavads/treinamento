package william.dia5.GenericEntity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

import william.silva.dia5.ValidaCpf;
@Entity
public class CorrentistaJuridica extends Correntista{
	@Column(unique=true, nullable = false)
	private CNPJ cnpj;
	private String razaoSocial;
	private LocalDate dataFundacao;
	
	
	private CorrentistaJuridica() {

	}


	public CorrentistaJuridica(CNPJ cnpj, String razaoSocial, LocalDate dataFundacao, String nome) {
		super(nome);
		if (!ValidaCpf.getInstance().isCNPJ(cnpj.getNumCnpj())) {
			throw new RuntimeException("O número de CNPJ é inválido!");
		}
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.dataFundacao = dataFundacao;
	}


	@Override
	public String toString() {
		return "CorrentistaJuridica [cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", dataFundacao=" + dataFundacao
				+ "]"+ getContas().size();
	}
	
	
}
