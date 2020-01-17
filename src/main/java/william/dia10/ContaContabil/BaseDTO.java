package william.dia10.ContaContabil;

import lombok.Data;
import lombok.EqualsAndHashCode;
import william.dia10.BaseEntity;

@Data
@EqualsAndHashCode(of = {"id"})
public abstract class BaseDTO<ENTITY extends BaseEntity> {

	protected int version;
	protected Long id;

	protected abstract ENTITY toEntity();

	protected abstract ENTITY mergeEntity(ENTITY actual);

}
