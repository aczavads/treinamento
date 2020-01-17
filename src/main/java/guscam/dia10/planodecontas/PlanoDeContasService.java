package guscam.dia10.planodecontas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import guscam.dia10.base.BaseService;
import guscam.dia10.base.RegistroNaoEncontrado;
import guscam.dia10.base.TransationalService;
import guscam.dia10.contacontabil.ContaContabil;
import guscam.dia10.contacontabil.ContaContabilRepository;

@TransationalService
public class PlanoDeContasService extends BaseService<
	PlanoDeContas,
	PlanoDeContasDTO,
	PlanoDeContasRepository
> {
	@Autowired
	private ContaContabilRepository repoContaContabil;

	public List<ContaContabil> getContas(Long id) {
		return new ArrayList<ContaContabil>(repository.findById(id).get().getContasContabeis());
	}

	public void adicionarContas(Long idDoPlanoDeContas, List<Long> idsDasContasParaAdicionar) {
		PlanoDeContas plano = getPlanoById(idDoPlanoDeContas);
		List<ContaContabil> contasParaAdicionar = getContasByIds(idsDasContasParaAdicionar);
		contasParaAdicionar.forEach(cc -> plano.adicionar(cc));
	}

	public void deleteContasDoPlano(Long idDoPlanoDeContas, List<Long> idsDasContasParaRemover) {
		PlanoDeContas plano = getPlanoById(idDoPlanoDeContas);
		List<ContaContabil> contasParaAdicionar = getContasByIds(idsDasContasParaRemover);
		contasParaAdicionar.forEach(cc -> plano.remover(cc));
	}

	public List<ContaContabil> getContasByIds(List<Long> idsDasContasParaAdicionar) {
		List<ContaContabil> contasParaAdicionar = repoContaContabil.findAllById(idsDasContasParaAdicionar);
		if (contasParaAdicionar.size() != idsDasContasParaAdicionar.size()) {
			throw new RegistroNaoEncontrado("Conta contábil não encontrada");
		}
		return contasParaAdicionar;
	}

	public PlanoDeContas getPlanoById(Long idDoPlanoDeContas) {
		PlanoDeContas plano = repository.findById(idDoPlanoDeContas)
				.orElseThrow(() -> new RegistroNaoEncontrado("Plano de contas não encontrado!"));
		return plano;
	}
}
