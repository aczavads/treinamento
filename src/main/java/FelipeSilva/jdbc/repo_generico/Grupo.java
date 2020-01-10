package FelipeSilva.jdbc.repo_generico;

import java.time.LocalDate;
import java.util.UUID;

public class Grupo extends Entidade{
private UUID id;
private String descricao;
private LocalDate dataDeFundacao;

public Grupo(String descricao, LocalDate dataDeFundacao) {
	super();
	this.descricao = descricao;
	this.dataDeFundacao = dataDeFundacao;
}
public String getDescricao() {
	return descricao;
}
public void setDescricao(String descricao) {
	this.descricao = descricao;
}
public LocalDate getDataDeFundacao() {
	return dataDeFundacao;
}
public void setDataDeFundacao(LocalDate dataDeFundacao) {
	this.dataDeFundacao = dataDeFundacao;
}
}
