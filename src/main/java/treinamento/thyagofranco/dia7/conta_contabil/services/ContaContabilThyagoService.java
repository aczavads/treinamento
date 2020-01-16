package treinamento.thyagofranco.dia7.conta_contabil.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import treinamento.thyagofranco.dia7.conta_contabil.DTOs.ContaContabilThyagoDTO;
import treinamento.thyagofranco.dia7.conta_contabil.entities.ContaContabilThyago;
import treinamento.thyagofranco.dia7.conta_contabil.exceptions.CodigoDaHierarquiaInvalidoException;
import treinamento.thyagofranco.dia7.conta_contabil.exceptions.RegistroNaoEncontrado;
import treinamento.thyagofranco.dia7.conta_contabil.repository.ContaContabilThyagoRepository;
import treinamento.thyagofranco.dia7.plano_de_contas.entity.PlanoDeContasT;

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
	
	public Page<ContaContabilThyago> recuperarTodas(Pageable pageable){
		return repo.recuperarTodas(pageable);
	}
	
	public Slice<ContaContabilThyago> recuperarTodasFatiadas(Pageable pageable){
		return repo.recuperarTodasFatiadas(pageable);
	}

	public List<ContaContabilThyago> recuperarTodasPaginadoManualmente(@Param("page") int page, @Param("size") int size) {
		
		return repo.recuperarTodasPaginadoManualmente(page, size);
	}

	public void deleteById(UUID id) {
		repo.deleteById(id);
	}
		

	
//	public List<ContaContabilThyago> findContasDoPlanoDeContas(UUID idPlanoDeContas) {
//		
//		return repo.findContaDoPlanoDeContas(idPlanoDeContas);
//	}

}
