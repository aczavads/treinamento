package treinamento.guilhermeperes.dia7.api.conta;

import org.springframework.web.bind.annotation.RequestMapping;

import treinamento.guilhermeperes.dia7.base.BaseController;
import treinamento.guilhermeperes.dia7.base.annotations.RestConfig;

@RestConfig
@RequestMapping("/api/contas")
public class ContaController extends BaseController<Conta, ContaRepository, ContaService> {
}
