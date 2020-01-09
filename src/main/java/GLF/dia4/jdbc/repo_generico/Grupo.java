package GLF.dia4.jdbc.repo_generico;

import java.time.LocalDate;
import java.util.UUID;

public class Grupo {

	private UUID id;
	private String descricao;
	private LocalDate dataDeFundação;
	public Grupo(String descricao, LocalDate dataDeFundação) {
		super();
		this.dataDeFundação = dataDeFundação;
		
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getDataDeFundação() {
		return dataDeFundação;
	}
	public void setDataDeFundação(LocalDate dataDeFundação) {
		this.dataDeFundação = dataDeFundação;
	}
	public UUID getId() {
		return id;
	}
	
	
}
