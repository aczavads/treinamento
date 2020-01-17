package schiavon.gabriel.dia7.movimentoContaContabil;

import org.springframework.beans.factory.annotation.Autowired;

import schiavon.gabriel.dia7.TransationalService;
import schiavon.gabriel.dia7.base.BaseService;
import schiavon.gabriel.dia7.conta_contabil.MyContaContabilService;

@TransationalService
public class MyMovimentoContaContabilService extends BaseService<Long, MyMovimentoContaContabil, MyMovimentoContaContabilDTO, MyMovimentoContaContabilRepository>{

	@Autowired
	private MyContaContabilService myContaContabilService;
	
	@Override
	public MyMovimentoContaContabil beforeUpdate(MyMovimentoContaContabilDTO dto, MyMovimentoContaContabil toSave) {
		toSave.setContaContabil(myContaContabilService.findById(dto.getContaContabilId()));
		return toSave;
	}
	
	@Override
	public MyMovimentoContaContabil beforeSave(MyMovimentoContaContabilDTO dto, MyMovimentoContaContabil paraSalvar) {
		paraSalvar.setContaContabil(myContaContabilService.findById(dto.getContaContabilId()));
		return paraSalvar;
	}
	
}
