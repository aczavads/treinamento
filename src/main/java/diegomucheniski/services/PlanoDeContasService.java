package diegomucheniski.services;

import java.util.List;
import java.util.Optional;
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
	private PlanoDeContasRepository planoDeContasRepository;

	@Autowired
	private ContaContabilRepository contaContabilRepository;

	@Override
	public PlanoDeContas save(PlanoDeContasDTO dto) {		
		return super.save(dto);
	}
	
	@Override
	public void update(PlanoDeContasDTO dto) {		
		super.update(dto);
	}

	public PlanoDeContas adicionarConta(Long idPlanoDeContas, Set<ContaContabil> contasContabeis) {
		Optional<PlanoDeContas> planoDeContas = planoDeContasRepository.findById(idPlanoDeContas);
		planoDeContas.get().setContasContabeis(contasContabeis);
		return planoDeContas.get();
	}

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
		PlanoDeContas plano = planoDeContasRepository.findById(idDoPlanoDeContas).orElseThrow(() -> new RegistroNaoEncontrado("Plano de contas não encontrado!"));
		return plano;
	}
 
}
