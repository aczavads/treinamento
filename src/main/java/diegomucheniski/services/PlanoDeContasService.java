package diegomucheniski.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import diegomucheniski.annotations.TransactionalService;
import diegomucheniski.domains.ContaContabil;
import diegomucheniski.domains.PlanoDeContas;
import diegomucheniski.dto.PlanoDeContasDTO;
import diegomucheniski.repositories.ContaContabilRepository;
import diegomucheniski.repositories.PlanoDeContasRepository;
import diegomucheniski.services.exceptions.RegistroNaoEncontrado;

@TransactionalService
public class PlanoDeContasService {

	@Autowired
	private PlanoDeContasRepository planoDeContasRepository;

	@Autowired
	private ContaContabilRepository contaContabilRepository;

	public PlanoDeContas save(PlanoDeContasDTO planoDeContasDTO) {
		PlanoDeContas planoDeContas = new PlanoDeContas(planoDeContasDTO.getId(),
				planoDeContasDTO.getDescricao(), planoDeContasDTO.getInicioVigencia(),
				planoDeContasDTO.getFimVigencia());
		return planoDeContasRepository.save(planoDeContas);
	}
	
	public PlanoDeContas findById(UUID planoDeContasId) {
		return planoDeContasRepository.findById(planoDeContasId).orElseThrow(() -> new RegistroNaoEncontrado("Não foi possível encontrar o plano de contas"));
	}

	public List<PlanoDeContas> findAll() {
		return planoDeContasRepository.findAll();
	}

	public PlanoDeContas adicionarConta(UUID idPlanoDeContas, Set<ContaContabil> contasContabeis) {
		Optional<PlanoDeContas> planoDeContas = planoDeContasRepository.findById(idPlanoDeContas);
		planoDeContas.get().setContasContabeis(contasContabeis);
		return planoDeContas.get();
	}

	public Set<ContaContabil> findContasByPlanoId(UUID planoDeContasId) {
		PlanoDeContas planoDeContas = findById(planoDeContasId);		
		return planoDeContas.getContasContabeis();
	}

	public void adicionarContas(UUID planoDeContasId, List<UUID> idsDasContasParaAdicionar) {
		PlanoDeContas planoDeContas = findById(planoDeContasId);
		for (UUID contaContabilId : idsDasContasParaAdicionar) {
			ContaContabil novaConta = contaContabilRepository.findById(contaContabilId).orElseThrow(() -> new RegistroNaoEncontrado("Não foi possível encontrar a conta"));
			planoDeContas.adicionarConta(novaConta);
		}
	}

	public void removerConta(UUID planoDeContasId,  List<UUID> idsDasContasParaRemover) {
		PlanoDeContas planoDeContas = findById(planoDeContasId);
		for (UUID contaContabilId : idsDasContasParaRemover) {
			ContaContabil novaConta = contaContabilRepository.findById(contaContabilId).orElseThrow(() -> new RegistroNaoEncontrado("Não foi possível encontrar a conta"));
			planoDeContas.removerConta(novaConta);
		}	
	}

	public void deleteById(UUID planoDeContasId) {
		planoDeContasRepository.deleteById(planoDeContasId);		
	}
	
	public void update(PlanoDeContasDTO planoDeContasDTO) {
		PlanoDeContas planoDeContas = planoDeContasRepository.findById(planoDeContasDTO.getId()).orElseThrow(() -> new RegistroNaoEncontrado("Registro não encontrado!"));
		planoDeContas.setDescricao(planoDeContasDTO.getDescricao());
		planoDeContas.setInicioVigencia(planoDeContasDTO.getInicioVigencia());
		planoDeContas.setFimVigencia(planoDeContasDTO.getFimVigencia());
	}

}
