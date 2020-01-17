package diegomucheniski.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import diegomucheniski.annotations.TransactionalService;
import diegomucheniski.base.BaseService;
import diegomucheniski.domains.ContaContabil;
import diegomucheniski.domains.PlanoDeContas;
import diegomucheniski.dto.PlanoDeContasDTO;
import diegomucheniski.repositories.ContaContabilRepository;
import diegomucheniski.repositories.PlanoDeContasRepository;
import diegomucheniski.services.exceptions.RegistroNaoEncontrado;

@TransactionalService
public class PlanoDeContasService extends BaseService<PlanoDeContas, PlanoDeContasDTO, PlanoDeContasRepository> {

	@Autowired
	private ContaContabilRepository contaContabilRepository;

	public Set<ContaContabil> findContasByPlanoId(Long planoDeContasId) {
		PlanoDeContas planoDeContas = findById(planoDeContasId);		
		return planoDeContas.getContasContabeis();
	}

	public void adicionarContas(Long idDoPlanoDeContas, List<Long> idsDasContasParaAdicionar) {
		PlanoDeContas plano = recuperarPlano(idDoPlanoDeContas);
		List<ContaContabil> contasParaAdicionar = recuperarContasContabeis(idsDasContasParaAdicionar);
		contasParaAdicionar.forEach(contaContabil -> plano.adicionarConta(contaContabil));
	}
	
	public void removerContas(Long idDoPlanoDeContas, List<Long> idsDasContasParaRemover) {
		PlanoDeContas plano = recuperarPlano(idDoPlanoDeContas);
		List<ContaContabil> contasParaAdicionar = recuperarContasContabeis(idsDasContasParaRemover);
		contasParaAdicionar.forEach(contaContabil -> plano.removerConta(contaContabil));
	}
	
	private List<ContaContabil> recuperarContasContabeis(List<Long> idsDasContasParaAdicionar) {
		List<ContaContabil> contasParaProcessar = contaContabilRepository.findAllById(idsDasContasParaAdicionar);
		if (contasParaProcessar.size() != idsDasContasParaAdicionar.size()) {
			throw new RegistroNaoEncontrado("Conta contábil não encontrada");
		}
		return contasParaProcessar;
	}
	
	private PlanoDeContas recuperarPlano(Long idDoPlanoDeContas) {
		PlanoDeContas plano = repository.findById(idDoPlanoDeContas).orElseThrow(() -> new RegistroNaoEncontrado("Plano de contas não encontrado!"));
		return plano;
	}
 
}
