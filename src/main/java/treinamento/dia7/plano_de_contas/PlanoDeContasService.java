package treinamento.dia7.plano_de_contas;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import treinamento.dia7.conta_contabil.ContaContabil;
import treinamento.dia7.conta_contabil.ContaContabilRepository;
import treinamento.dia7.conta_contabil.RegistroNaoEncontrado;
import treinamento.dia7.conta_contabil.TransationalService;

@TransationalService
public class PlanoDeContasService {
	@Autowired
	private PlanoDeContasRepository repo;

	@Autowired
	private ContaContabilRepository repoContaContabil;

	public PlanoDeContas save(PlanoDeContasDTO dto) {
		PlanoDeContas novo = new PlanoDeContas(dto.getId(), dto.getDescricao(), dto.getInicioVigencia(),
				dto.getFimVigencia());
		return repo.save(novo);
	}

	public List<PlanoDeContas> findAll() {
		return repo.findAll();
	}

	public void adicionarContas(UUID idDoPlanoDeContas, List<UUID> idsDasContasParaAdicionar) {
		PlanoDeContas plano = repo
				.findById(idDoPlanoDeContas)
				.orElseThrow(() -> new RegistroNaoEncontrado("Plano de contas não encontrado!"));
		List<ContaContabil> contasParaAdicionar = repoContaContabil
				.findAllById(idsDasContasParaAdicionar);
		if (contasParaAdicionar.size() != idsDasContasParaAdicionar.size()) {
			throw new RegistroNaoEncontrado("Conta contábil não encontrada");
		}
		contasParaAdicionar.forEach(cc -> plano.adicionar(cc));
	}
}




