package schiavon.gabriel.dia7.movimentoContaContabil;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import schiavon.gabriel.dia7.base.BaseController;

@RestController
@RequestMapping("/movimentoscontascontabeis")
public class MyMovimentoContaContabilController extends
		BaseController<Long, MyMovimentoContaContabil, MyMovimentoContaContabilDTO, MyMovimentoContaContabilRepository, MyMovimentoContaContabilService> {

}
