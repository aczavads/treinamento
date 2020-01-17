package fernando_santos.treinamento.dia10.plano_de_contas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fernando_santos.treinamento.dia10.base.BaseService;
import fernando_santos.treinamento.dia10.base.RegistroNaoEncontrado;
import fernando_santos.treinamento.dia10.base.TransationalService;
import fernando_santos.treinamento.dia10.conta_contabil.ContaContabil;
import fernando_santos.treinamento.dia10.conta_contabil.ContaContabilRepository;

@TransationalService
public class PlanoDeContasService extends BaseService<
	PlanoDeContas, 
	PlanoDeContasDTO, 
	PlanoDeContasRepository> {

	@Autowired
	private PlanoDeContasRepository repo;

	@Autowired
	private ContaContabilRepository repoContaContabil;

	public PlanoDeContas save(PlanoDeContasDTO dto) {
		PlanoDeContas novo = PlanoDeContas.builder().id(dto.getId()).version(dto.getVersion())
				.descricao(dto.getDescricao()).inicioVigencia(dto.getInicioVigencia()).fimVigencia(dto.getFimVigencia())
				.build();
		return repo.save(novo);
	}

	public void update(PlanoDeContasDTO dto) {
//		PlanoDeContas recuperado = repo
//			.findById(dto.getId())
//			.orElseThrow(() -> new RegistroNaoEncontrado("Plano de contas não encontrado!"));
		PlanoDeContas recuperado = recuperarPlanoDeContas(dto.getId());
		recuperado.setDescricao(dto.getDescricao());
		recuperado.setInicioVigencia(dto.getInicioVigencia());
		recuperado.setFimVigencia(dto.getFimVigencia());
	}

	public List<PlanoDeContas> find() {
		return repo.findAll();
	}

	public List<ContaContabil> getContas(Long id) {
		return new ArrayList<ContaContabil>(repo.findById(id).get().getContasContabeis());
	}

	public void deleteById(Long id) {
		repo.deleteById(id);
	}

	public void adicionarContas(Long idDoPlanoDeContas, List<Long> idsDasContasParaAdicionar) {
		PlanoDeContas plano = recuperarPlanoDeContas(idDoPlanoDeContas);
		List<ContaContabil> contasParaAdicionar = recuperarContasContabeis(idsDasContasParaAdicionar);
		contasParaAdicionar.forEach(cc -> plano.adicionar(cc));
	}

	private List<ContaContabil> recuperarContasContabeis(List<Long> idsDasContasParaAdicionar) {
		List<ContaContabil> contasParaAdicionar = repoContaContabil.findAllById(idsDasContasParaAdicionar);
		if (contasParaAdicionar.size() != idsDasContasParaAdicionar.size()) {
			throw new RegistroNaoEncontrado("Conta contábil não encontrada");
		}
		return contasParaAdicionar;
	}

	private PlanoDeContas recuperarPlanoDeContas(Long idDoPlanoDeContas) {
		PlanoDeContas plano = repo.findById(idDoPlanoDeContas)
				.orElseThrow(() -> new RegistroNaoEncontrado("Plano de contas não encontrado!"));
		return plano;
	}

	public void deleteContasDoPlano(Long idDoPlanoDeContas, List<Long> idsDasContasParaRemover) {
		PlanoDeContas plano = recuperarPlanoDeContas(idDoPlanoDeContas);
		List<ContaContabil> contasParaAdicionar = recuperarContasContabeis(idsDasContasParaRemover);
		contasParaAdicionar.forEach(cc -> plano.remover(cc));
	}
}
