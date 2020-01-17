package fernando_santos.treinamento.dia10.conta_contabil;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fernando_santos.treinamento.dia10.base.BaseEntity;
import fernando_santos.treinamento.dia10.movimento_conta_contabil.MovimentoContaContabil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
@SuperBuilder
public class ContaContabil extends BaseEntity {

	private String codigo;
	private String nome;

	@ManyToOne
	@JsonIgnore
	private ContaContabil contaSuperior;

	@OneToMany(mappedBy = "contaSuperior")
	@JsonIgnore
	private List<ContaContabil> contasFilhas;

	@OneToMany(mappedBy = "contaContabil")
	@JsonIgnore
	private List<MovimentoContaContabil> movimentos;

	public Long getContaSuperiorId() {
		if (this.contaSuperior != null) {
			return this.contaSuperior.getId();
		}
		return null;
	}

}
