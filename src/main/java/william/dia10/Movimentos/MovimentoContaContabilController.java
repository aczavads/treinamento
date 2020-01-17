package william.dia10.Movimentos;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import william.dia10.ContaContabil.BaseController;

@RestController
@RequestMapping("/movimentoscontacontabil")
public class MovimentoContaContabilController extends
		BaseController<MovimentoContaContabil,
		MovimentoContaContabilDTO, 
		MovimentoContaContabilRepository,
		MovimentoContaContabilService> {

}
