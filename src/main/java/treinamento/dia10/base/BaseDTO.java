package treinamento.dia10.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = {"id"})
public class BaseDTO<ENTITY extends BaseEntity> {
	private Long id;
	private int version;
	
	public ENTITY toEntity() {
		return null;
	}

}
