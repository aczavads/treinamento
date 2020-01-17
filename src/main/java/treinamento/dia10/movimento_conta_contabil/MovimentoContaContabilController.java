package treinamento.dia10.movimento_conta_contabil;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import treinamento.dia10.base.BaseController;

@RestController
@RequestMapping("/movimentoscontacontabil")
public class MovimentoContaContabilController extends BaseController<
	MovimentoContaContabil, 
	MovimentoContaContabilDTO, 
	MovimentoContaContabilRepository, 
	MovimentoContaContabilService> {

}
