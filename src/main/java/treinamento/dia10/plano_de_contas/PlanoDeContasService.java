package treinamento.dia10.plano_de_contas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import treinamento.dia10.base.BaseService;
import treinamento.dia10.base.RegistroNaoEncontrado;
import treinamento.dia10.base.TransationalService;
import treinamento.dia10.conta_contabil.ContaContabil;
import treinamento.dia10.conta_contabil.ContaContabilRepository;

@TransationalService
public class PlanoDeContasService extends BaseService<
	PlanoDeContas, 
	PlanoDeContasDTO, 
	PlanoDeContasRepository> {
		
	@Autowired
	private ContaContabilRepository repoContaContabil;

	public List<ContaContabil> getContas(Long id) {
		return new ArrayList<ContaContabil>(repo.findById(id).get().getContasContabeis());
	}
	public void adicionarContas(Long idDoPlanoDeContas, List<Long> idsDasContasParaAdicionar) {
		PlanoDeContas plano = findById(idDoPlanoDeContas);
		List<ContaContabil> contasParaAdicionar = recuperarContasContabeis(idsDasContasParaAdicionar);
		contasParaAdicionar.forEach(cc -> plano.adicionar(cc));
	}
	public void deleteContasDoPlano(Long idDoPlanoDeContas, List<Long> idsDasContasParaRemover) {
		PlanoDeContas plano = findById(idDoPlanoDeContas);
		List<ContaContabil> contasParaAdicionar = recuperarContasContabeis(idsDasContasParaRemover);
		contasParaAdicionar.forEach(cc -> plano.remover(cc));	
	}
	private List<ContaContabil> recuperarContasContabeis(List<Long> idsDasContasParaAdicionar) {
		List<ContaContabil> contasParaAdicionar = repoContaContabil
				.findAllById(idsDasContasParaAdicionar);
		if (contasParaAdicionar.size() != idsDasContasParaAdicionar.size()) {
			throw new RegistroNaoEncontrado("Conta contábil não encontrada");
		}
		return contasParaAdicionar;
	}
/* 
 EXEMPLO PASSANDO UMA LAMBDA EXPRESSION COMO ARGUMENTO DO PROCESSAR.
 IMPORTANTE: FICOU MAIS OBSCURA DO QUE A SOLUÇÃO ADOTADA.
	private void processarContas(List<Long> idsDasContasParaProcessar,Consumer<ContaContabil> acao) {
		List<ContaContabil> contasParaProcessar = repoContaContabil
				.findAllById(idsDasContasParaProcessar);
		if (contasParaProcessar.size() != idsDasContasParaProcessar.size()) {
			throw new RegistroNaoEncontrado("Conta contábil não encontrada");
		}
		contasParaProcessar.forEach(acao);		
	}
	
	public void adicionarContas(Long idDoPlanoDeContas, List<Long> idsDasContasParaAdicionar) {
		PlanoDeContas plano = recuperarPlano(idDoPlanoDeContas);
		processarContas(idsDasContasParaAdicionar, (cc) -> plano.adicionar(cc));
	}

	public void deleteContasDoPlano(Long idDoPlanoDeContas, List<Long> idsDasContasParaRemover) {
		PlanoDeContas plano = recuperarPlano(idDoPlanoDeContas);
		processarContas(idsDasContasParaRemover, (cc) -> plano.remover(cc));
	}	
 */
}




