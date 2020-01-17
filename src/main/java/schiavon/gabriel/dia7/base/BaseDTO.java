package schiavon.gabriel.dia7.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = {"id"})
public abstract class BaseDTO<ID, ENTIDADE> {

	private ID id;
	
	public ID getId() {
		return id;
	}

	protected abstract ENTIDADE toEntity();
	protected abstract ENTIDADE mergeEntity(ENTIDADE entidade);
	
}
