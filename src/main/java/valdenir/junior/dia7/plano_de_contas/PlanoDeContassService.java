package valdenir.junior.dia7.plano_de_contas;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import treinamento.dia7.conta_contabil.TransationalService;
import valdenir.junior.dia7.RegistroNaoEncontrato;
import valdenir.junior.dia7.conta_contabil.ContaContabils;
import valdenir.junior.dia7.conta_contabil.ContaContabilsRepository;

@TransationalService
public class PlanoDeContassService {
	@Autowired
	private PlanoDeContassRepository repo;
	@Autowired
	private ContaContabilsRepository repoContaContabils;

	public PlanoDeContass save(PlanoDeContassDTO dto) {
		return repo.save(
				new PlanoDeContass(dto.getId(), dto.getDescricao(), dto.getInicioVigencia(), dto.getFimVigencia()));
	}

	public List<PlanoDeContass> findAll() {
		return repo.findAll();
	}

	public void adicionarContas(UUID idDoPlanoDeContas, List<UUID> idsDasContasParaAdicionar) {
		PlanoDeContass planoDeContas = repo.findById(idDoPlanoDeContas)
				.orElseThrow(() -> new RegistroNaoEncontrato("não foi possivel encontrar o plano de contas"));

		List<ContaContabils> contasParaAdicionar = repoContaContabils.findAllById(idsDasContasParaAdicionar);

		contasParaAdicionar.forEach(cc -> planoDeContas.adicionar(cc));
	}

	public List<ContaContabils> buscarContaContabilsPorPlanoDeContas(UUID id) {
		return repoContaContabils.findContasDoPlanoDeContas(id);
	}

	public void deletarContasDoPlanoDeContas(UUID idDoPlanoDeContas, List<UUID> idsDasContasParaAdicionar) {
		PlanoDeContass planoDeContas = repo.findById(idDoPlanoDeContas)
				.orElseThrow(() -> new RegistroNaoEncontrato("não foi possivel encontrar o plano de contas"));

		List<ContaContabils> contasParaAdicionar = repoContaContabils.findAllById(idsDasContasParaAdicionar);

		contasParaAdicionar.forEach(cc -> planoDeContas.remover(cc));
	}

	public void remove(UUID id) {
		repo.delete(repo.findById(id).orElseThrow(() -> new RegistroNaoEncontrato("plano de contas não encontrados")));
	}
}
