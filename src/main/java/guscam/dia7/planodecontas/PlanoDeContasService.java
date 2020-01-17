package guscam.dia7.planodecontas;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import guscam.dia7.RegistroNaoEncontrado;
import guscam.dia7.contacontabil.ContaContabil;
import guscam.dia7.contacontabil.ContaContabilRepository;
import treinamento.dia7.conta_contabil.TransationalService;

@TransationalService
public class PlanoDeContasService {
	@Autowired
	private PlanoDeContasRepository repo;
	@Autowired
	private ContaContabilRepository repoContaContabil;

	public PlanoDeContas save(PlanoDeContasDTO entity) {
		PlanoDeContas novo = new PlanoDeContas(
				entity.getId(),
				entity.getDescricao(),
				entity.getInicioVigencia(),
				entity.getFimVigencia());
		return repo.save(novo);
	}

	public void update(PlanoDeContasDTO entity) {
		PlanoDeContas plano = getPlanoById(entity.getId());
		plano.setDescricao(entity.getDescricao());
		plano.setFimVigencia(entity.getFimVigencia());
		plano.setInicioVigencia(entity.getInicioVigencia());
	}

	public List<PlanoDeContas> findAll() {
		return repo.findAll();
	}

	public void adicionarContas(UUID idDoPlano, List<UUID> idsDasContas) {
		PlanoDeContas plano = getPlanoById(idDoPlano);
		List<ContaContabil> contas = getContasDoPlanoByIds(idsDasContas);
		contas.forEach((conta) -> plano.adicionarConta(conta));
	}

	public void removerContas(UUID idDoPlano, List<UUID> idsDasContas) {
		PlanoDeContas plano = getPlanoById(idDoPlano);
		List<ContaContabil> contas = getContasDoPlanoByIds(idsDasContas);
		contas.forEach((conta) -> plano.removerConta(conta));
	}

	public PlanoDeContas getPlanoById(UUID idDoPlano) {
		PlanoDeContas plano = repo.findById(idDoPlano).orElseThrow(() -> new RegistroNaoEncontrado("Plano nao encontrado"));
		return plano;
	}

	public List<ContaContabil> getContasDoPlanoByIds(List<UUID> idsDasContas) {
		List<ContaContabil> contas = repoContaContabil.findAllById(idsDasContas);
		if (contas.size() != idsDasContas.size()) {
			throw new IllegalArgumentException("Id não encontrado");
		}
		return contas;
	}

	public void remover(UUID idDoPlano) {
		repo.deleteById(idDoPlano);
	}

}
