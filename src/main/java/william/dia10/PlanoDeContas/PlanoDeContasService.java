package william.dia10.PlanoDeContas;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import william.dia10.ContaContabil.BaseService;
import william.dia10.ContaContabil.ContaContabil;
import william.dia10.ContaContabil.ContaContabilService;
import william.dia10.Exceptions.RegistroNaoEncontrado;

@Service
@Transactional
public class PlanoDeContasService extends BaseService<PlanoDeContas, PlanoDeContasDTO, PlanoDeContasRepository> {
	@Autowired
	private PlanoDeContasRepository repository;

	@Autowired
	private ContaContabilService contabilService;

	public PlanoDeContasService(PlanoDeContasRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public PlanoDeContas save(PlanoDeContasDTO dto) {
		PlanoDeContas contas = dto.toEntity();

		return repository.save(contas);
	}


	public List<ContaContabil> addContas(Long idDoPlanoDeContas, List<Long> idsDasContasParaAdicionar) {
		PlanoDeContas plano = repository.findById(idDoPlanoDeContas)
				.orElseThrow(() -> new RegistroNaoEncontrado("Plano de Contas não encontrado"));

		List<ContaContabil> contas = contabilService.findAllById(idsDasContasParaAdicionar);
		for (ContaContabil contaContabil : contas) {
			plano.adicionarConta(contaContabil);
		}
		return contas;
	}

	public List<ContaContabil> removeContas(Long idDoPlanoDeContas, List<Long> idsDasContasParaRemover) {
		PlanoDeContas planoDeContas = repository.findById(idDoPlanoDeContas)
				.orElseThrow(() -> new RegistroNaoEncontrado("Plano de Contas não Encontrado"));
		List<ContaContabil> contas = contabilService.findAllById(idsDasContasParaRemover);
		for (ContaContabil contaContabil : contas) {
			planoDeContas.removerConta(contaContabil);
		}
		return contas;
	}

	public Set<ContaContabil> getContas(Long idDoPlanoDeContas) {
		PlanoDeContas planoDeContas = repository.findById(idDoPlanoDeContas)
				.orElseThrow(() -> new RegistroNaoEncontrado("Plano de Contas não Encontrado"));

		return planoDeContas.getContasContabeis();
	}

}
