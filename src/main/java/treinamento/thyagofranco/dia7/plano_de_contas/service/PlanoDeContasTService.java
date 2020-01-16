package treinamento.thyagofranco.dia7.plano_de_contas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import treinamento.dia7.conta_contabil.RegistroNaoEncontrado;
import treinamento.dia7.conta_contabil.TransationalService;
import treinamento.thyagofranco.dia7.conta_contabil.entities.ContaContabilThyago;
import treinamento.thyagofranco.dia7.conta_contabil.repository.ContaContabilThyagoRepository;
import treinamento.thyagofranco.dia7.plano_de_contas.DTO.PlanoDeContasTDTO;
import treinamento.thyagofranco.dia7.plano_de_contas.entity.PlanoDeContasT;
import treinamento.thyagofranco.dia7.plano_de_contas.repository.PlanodeContasTRepository;

@TransationalService
public class PlanoDeContasTService {

	@Autowired
	private PlanodeContasTRepository repo;
	
	@Autowired
	private ContaContabilThyagoRepository repoContaContabil;
	
	public PlanoDeContasT save(PlanoDeContasTDTO dto) {
		PlanoDeContasT novo = new PlanoDeContasT(
				dto.getId(), dto.getDescricao(), dto.getInicioVigencia(), dto.getFimVigencia());
		return repo.save(novo);
	}
	
	public List<PlanoDeContasT> findAll(){
		return repo.findAll();
	}

	public void adicionarContas(
			UUID idPlanoDeContas,
			List<UUID> idsDasContasParaAdicionar) {
		PlanoDeContasT plano = repo.findById(idPlanoDeContas)
				.orElseThrow(()-> new RegistroNaoEncontrado("Não foi possível encontrar o Plano de contas!"));
		List<ContaContabilThyago> contasParaAdicionar = repoContaContabil
				.findAllById(idsDasContasParaAdicionar);
		
		if(contasParaAdicionar.size() != idsDasContasParaAdicionar.size()) {
			throw new RegistroNaoEncontrado("Conta contábil não encontrada");
		}
		
		contasParaAdicionar
			.forEach(cc -> plano.adicionar(cc));
		
		
	}

	public List<ContaContabilThyago> getContas(UUID id) {
		return new ArrayList<ContaContabilThyago>(repo.findById(id).get().getContasContabeis());
		
	}

	public void deleteById(UUID idPlanoDeContas) {
		repo.deleteById(idPlanoDeContas);
		
	}
	
	
}
