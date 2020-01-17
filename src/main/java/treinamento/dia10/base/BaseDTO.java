package treinamento.dia10.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = {"id"})
public abstract class BaseDTO<ENTITY extends BaseEntity> {
	protected Long id;
	protected int version;
	
	public abstract ENTITY toEntity();

	public abstract ENTITY mergeEntity(ENTITY entity);

}
