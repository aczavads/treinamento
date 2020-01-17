package treinamento.dia10.movimento_conta_contabil;

import org.springframework.beans.factory.annotation.Autowired;

import treinamento.dia10.base.BaseService;
import treinamento.dia10.base.TransationalService;
import treinamento.dia10.conta_contabil.ContaContabilService;

@TransationalService
public class MovimentoContaContabilService extends BaseService<
		MovimentoContaContabil, 
		MovimentoContaContabilDTO, 
		MovimentoContaContabilRepository>{

	@Autowired
	private ContaContabilService serviceContaContabil;

	@Override
	public MovimentoContaContabil beforeSave(MovimentoContaContabilDTO dto, MovimentoContaContabil toSave) {
		return this.beforeUpdate(dto, toSave);
	}
	
	@Override
	public MovimentoContaContabil beforeUpdate(MovimentoContaContabilDTO dto, MovimentoContaContabil toSave) {
		toSave.setContaContabil(serviceContaContabil.findByIdOrNull(dto.getContaContabilId()));
		return toSave;
	}
}
