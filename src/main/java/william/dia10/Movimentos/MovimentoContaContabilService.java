package william.dia10.Movimentos;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import william.dia10.ContaContabil.BaseService;
@Service
@Transactional
public class MovimentoContaContabilService
		extends BaseService<MovimentoContaContabil, MovimentoContaContabilDTO, MovimentoContaContabilRepository> {

}
