package treinamento.thyagofranco.dia7.conta_contabil;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import treinamento.thyagofranco.dia7.conta_contabil.exceptions.CodigoDaHierarquiaInvalidoException;
import treinamento.thyagofranco.dia7.conta_contabil.exceptions.RegistroNaoEncontrado;

//Nossa anotação criada para @Service @Transactional
@TransactionalService
public class ContaContabilThyagoService {

	@Autowired
	private ContaContabilThyagoRepository repo;

	public List<ContaContabilThyago> findAll() {
		return repo.findAll();
	}

	public ContaContabilThyago save(ContaContabilThyagoDTO nova) {
		ContaContabilThyago contaSuperior = null;

		if (nova.getContaSuperiorId() != null) {

			contaSuperior = findById(nova.getContaSuperiorId()).orElseThrow(() -> new RegistroNaoEncontrado(
					"Registro de Conta contábil não encontrado com id: " + nova.getId()));

			
		}
		ContaContabilThyago novaContaContabilThyago = null;
		if (nova.getId() == null) {
			novaContaContabilThyago = new ContaContabilThyago(nova.getCodigo(), nova.getNome(), contaSuperior);
		} else {
			novaContaContabilThyago = new ContaContabilThyago(nova.getId(), nova.getCodigo(), nova.getNome(),
					contaSuperior);
		}
		return repo.save(novaContaContabilThyago);
	}

	public Optional<ContaContabilThyago> findById(UUID id) {
		return repo.findById(id);
	}

	public Long contarContas() {
		return repo.contarContas();
	}

	public List<ContaContabilThyago> selecionarContasRaiz() {
		return repo.selecionarContasRaiz();
	}

	public List<Map<String, Object>> recuperarHierarquia() {
		return repo.recuperarHierarquia();
	}

}
