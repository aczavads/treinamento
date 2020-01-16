package william.dia8;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import william.dia8.ContaContabilRepository;
import william.dia8.Exceptions.RegistroNaoEncontrado;

@Service
@Transactional
public class PlanoDeContasService {
	@Autowired
	private PlanoDeContasRepository repository;

	@Autowired
	private ContaContabilService contabilService;

	public PlanoDeContasService(PlanoDeContasRepository repository) {
		super();
		this.repository = repository;
	}

	public PlanoDeContas save(PlanoDeContasDTO dto) {
		PlanoDeContas contas = new PlanoDeContas(dto.getId(), dto.getDescricao(), dto.getInicioVigencia(),
				dto.getFimVigencia());
		return repository.save(contas);
	}

	public List<PlanoDeContas> findAll() {
		return repository.findAll();
	}

	public List<ContaContabil> addContas(UUID idDoPlanoDeContas, List<UUID> idsDasContasParaAdicionar) {
		PlanoDeContas plano = repository.findById(idDoPlanoDeContas)
				.orElseThrow(() -> new RegistroNaoEncontrado("Plano de Contas não encontrado"));

		List<ContaContabil> contas = contabilService.findAllById(idsDasContasParaAdicionar);
		for (ContaContabil contaContabil : contas) {
			plano.adicionarConta(contaContabil);
		}
		return contas;
	}

	public List<ContaContabil> removeContas(UUID idDoPlanoDeContas, List<UUID> idsDasContasParaRemover) {
		PlanoDeContas planoDeContas = repository.findById(idDoPlanoDeContas)
				.orElseThrow(() -> new RegistroNaoEncontrado("Plano de Contas não Encontrado"));
		List<ContaContabil> contas = contabilService.findAllById(idsDasContasParaRemover);
		for (ContaContabil contaContabil : contas) {
			planoDeContas.removerConta(contaContabil);
		}
		return contas;
	}

	public void remove(UUID idDoPlanoDeContas) {
		// TODO Auto-generated method stub
		repository.deleteById(idDoPlanoDeContas);
	}

	public Set<ContaContabil> getContas(UUID idDoPlanoDeContas) {
		PlanoDeContas planoDeContas = repository.findById(idDoPlanoDeContas)
				.orElseThrow(() -> new RegistroNaoEncontrado("Plano de Contas não Encontrado"));

		return planoDeContas.getContasContabeis();
	}

}
