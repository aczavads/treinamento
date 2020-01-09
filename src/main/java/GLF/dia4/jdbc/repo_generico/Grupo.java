package GLF.dia4.jdbc.repo_generico;

import java.time.LocalDate;
import java.util.UUID;

public class Grupo {

	private UUID id;
	private String descricao;
	private LocalDate dataDeFunda��o;
	public Grupo(String descricao, LocalDate dataDeFunda��o) {
		super();
		this.dataDeFunda��o = dataDeFunda��o;
		
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getDataDeFunda��o() {
		return dataDeFunda��o;
	}
	public void setDataDeFunda��o(LocalDate dataDeFunda��o) {
		this.dataDeFunda��o = dataDeFunda��o;
	}
	public UUID getId() {
		return id;
	}
	
	
}
