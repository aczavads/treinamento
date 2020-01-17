package guscam.dia10.movimentocontacontabil;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import guscam.dia10.base.BaseController;

@RestController
@RequestMapping("/movimentoscontacontabil")
public class MovimentoContaContabilController extends BaseController<
	MovimentoContaContabil,
	MovimentoContaContabilDTO,
	MovimentoContaContabilRepository,
	MovimentoContaContabilService
> {
	
}








