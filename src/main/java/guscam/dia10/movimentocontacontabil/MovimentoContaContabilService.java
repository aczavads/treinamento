package guscam.dia10.movimentocontacontabil;

import org.springframework.beans.factory.annotation.Autowired;

import guscam.dia10.base.BaseService;
import guscam.dia10.base.TransationalService;
import guscam.dia10.contacontabil.ContaContabilRepository;

@TransationalService
public class MovimentoContaContabilService extends BaseService<
	MovimentoContaContabil,
	MovimentoContaContabilDTO,
	MovimentoContaContabilRepository
> {
	@Autowired
	private ContaContabilRepository repoContaContabil;
	
}













