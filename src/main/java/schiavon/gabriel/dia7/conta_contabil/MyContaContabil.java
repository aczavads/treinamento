package schiavon.gabriel.dia7.conta_contabil;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import schiavon.gabriel.dia5.jpa.associacoes.BaseEntity;

@Data
@Entity
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class MyContaContabil extends BaseEntity {

	private String codigo;
	private String nome;

	@JsonIgnore
	@ManyToOne
	private MyContaContabil contaSuperior;
	
	@JsonIgnore
	@OneToMany(mappedBy = "contaSuperior")
	private List<MyContaContabil> contasFilhas;

	public MyContaContabil(Long id, String codigo, String nome, MyContaContabil contaSuperior) {
		super(id);
		this.codigo = codigo;
		this.nome = nome;
		this.contaSuperior = contaSuperior;
	}
		
	public Long getContaSuperiorId() {
		if (this.contaSuperior != null) {
			return this.contaSuperior.getId();
		}
		return null;
	}
}
