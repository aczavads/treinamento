package fernando_santos.treinamento.dia10.movimento_conta_contabil;

import org.springframework.beans.factory.annotation.Autowired;

import fernando_santos.treinamento.dia10.base.BaseService;
import fernando_santos.treinamento.dia10.conta_contabil.ContaContabilService;

public class MovimentoContaContabilService extends BaseService<MovimentoContaContabil, MovimentoContaContabilDTO, MovimentoContaContabilRepository>{
	
	@Autowired
	private ContaContabilService contaContabilService;
	
	@Override
	public MovimentoContaContabil beforeUpdate(MovimentoContaContabilDTO dto, MovimentoContaContabil toSave) {
		toSave.setContaContabil(contaContabilService.findById(dto.getContaContabilId()));
		return toSave;
	}

}
