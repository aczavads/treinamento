package treinamento.diegomucheniski.dia7.plano_de_contas;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import treinamento.diegomucheniski.annotations.TransactionalService;
import treinamento.diegomucheniski.dia7.conta_contabil.ContaContabilMucheniski;
import treinamento.diegomucheniski.dia7.conta_contabil.ContaContabilMucheniskiRepository;
import treinamento.diegomucheniski.dia7.exceptions.RegistroNaoEncontradoMucheniski;

@TransactionalService
public class PlanoDeContasMucheniskiService {

	@Autowired
	private PlanoDeContasMucheniskiRepository planoDeContasRepository;

	@Autowired
	private ContaContabilMucheniskiRepository contaContabilRepository;

	public PlanoDeContasMucheniski save(PlanoDeContasMucheniskiDTO planoDeContasDTO) {
		PlanoDeContasMucheniski planoDeContas = new PlanoDeContasMucheniski(planoDeContasDTO.getId(),
				planoDeContasDTO.getDescricao(), planoDeContasDTO.getInicioVigencia(),
				planoDeContasDTO.getFimVigencia());
		return planoDeContasRepository.save(planoDeContas);
	}
	
	public PlanoDeContasMucheniski findById(UUID planoDeContasId) {
		return planoDeContasRepository.findById(planoDeContasId).orElseThrow(() -> new RegistroNaoEncontradoMucheniski("Não foi possível encontrar o plano de contas"));
	}

	public List<PlanoDeContasMucheniski> findAll() {
		return planoDeContasRepository.findAll();
	}

	public PlanoDeContasMucheniski adicionarConta(UUID idPlanoDeContas, Set<ContaContabilMucheniski> contasContabeis) {
		Optional<PlanoDeContasMucheniski> planoDeContas = planoDeContasRepository.findById(idPlanoDeContas);
		planoDeContas.get().setContasContabeis(contasContabeis);
		return planoDeContas.get();
	}

	public Set<ContaContabilMucheniski> findContasByPlanoId(UUID planoDeContasId) {
		PlanoDeContasMucheniski planoDeContas = findById(planoDeContasId);		
		return planoDeContas.getContasContabeis();
	}

	public void adicionarContas(UUID planoDeContasId, List<UUID> idsDasContasParaAdicionar) {
		PlanoDeContasMucheniski planoDeContas = findById(planoDeContasId);
		for (UUID contaContabilId : idsDasContasParaAdicionar) {
			ContaContabilMucheniski novaConta = contaContabilRepository.findById(contaContabilId).orElseThrow(() -> new RegistroNaoEncontradoMucheniski("Não foi possível encontrar a conta"));
			planoDeContas.adicionarConta(novaConta);
		}
	}

	public void removerConta(UUID planoDeContasId,  List<UUID> idsDasContasParaRemover) {
		PlanoDeContasMucheniski planoDeContas = findById(planoDeContasId);
		for (UUID contaContabilId : idsDasContasParaRemover) {
			ContaContabilMucheniski novaConta = contaContabilRepository.findById(contaContabilId).orElseThrow(() -> new RegistroNaoEncontradoMucheniski("Não foi possível encontrar a conta"));
			planoDeContas.removerConta(novaConta);
		}	
	}

	public void deleteById(UUID planoDeContasId) {
		planoDeContasRepository.deleteById(planoDeContasId);		
	}

}
