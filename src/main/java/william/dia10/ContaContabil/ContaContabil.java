package william.dia10.ContaContabil;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import william.dia10.BaseEntity;


@Entity
@Data
@ToString
@SuperBuilder
@NoArgsConstructor
public class ContaContabil extends BaseEntity {
	private String codigo;
	private String nome;
	

	@ManyToOne
	private ContaContabil contaSuperior;
	
	@JsonIgnore
	@OneToMany(mappedBy = "contaSuperior")
	private List<ContaContabil> contasFilhas;

	public Long getContaSuperior() {
		if (this.contaSuperior != null) {
			return this.contaSuperior.getId();
		}
		return null;
	}
}
