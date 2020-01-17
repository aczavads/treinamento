package thyagofranco.dia10.conta_contabil.base;

import lombok.Data;
import lombok.EqualsAndHashCode;
import thyagofranco.dia10.base.BaseEntity;

@Data
@EqualsAndHashCode(of = {"id"})
public class BaseDTO<ENTITY extends BaseEntity> {

	private Long id;
	private int version;
	
	public ENTITY toEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
