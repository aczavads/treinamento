package diegomucheniski.services;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import diegomucheniski.annotations.TransactionalService;
import diegomucheniski.domains.ContaContabil;
import diegomucheniski.dto.ContaContabilDTO;
import diegomucheniski.repositories.ContaContabilRepository;
import diegomucheniski.services.exceptions.RegistroNaoEncontradoMucheniski;


@TransactionalService
public class ContaContabilService {
	
	@Autowired
	private ContaContabilRepository repository;
	
	public List<ContaContabil> findAll() {
		return repository.findAll();		
	}
	
	public UUID save(ContaContabilDTO contaContabilDTO) {
		ContaContabil contaSuperior = null;
		if (contaContabilDTO.getContaSuperiorId() != null) {
			contaSuperior = findById(contaContabilDTO.getContaSuperiorId());
		}
		ContaContabil novaContaContabil = null;
		if (contaContabilDTO.getId() == null) {
			novaContaContabil = new ContaContabil(contaContabilDTO.getCodigo(), contaContabilDTO.getNome(), contaSuperior);			
		} else {
			novaContaContabil = new ContaContabil(contaContabilDTO.getId(), contaContabilDTO.getCodigo(), contaContabilDTO.getNome(), contaSuperior);			
		}
		return repository.save(novaContaContabil).getId();
	}
	
//	private static boolean ehCodigoComPai(String codigoPai, String codigoFilho) {
//		String codigoComparado = codigoFilho.substring(0, codigoPai.length());
//		if (codigoComparado.equals(codigoPai)) {
//			return true;
//		}	
//		return false;	
//	}
//	
//	private static boolean ehPontoOProximoDigito(String codigoPai, String codigoFilho) {		
//		if ((codigoFilho.substring(codigoPai.length(), codigoPai.length()+1)).equals(".")) {
//			return true;
//		}		
//		return false;
//	}
	
	public ContaContabil findById(UUID id) {
		return repository.findById(id).orElseThrow(() -> new RegistroNaoEncontradoMucheniski("Registro não encontrado!"));
	}
	
	public Long contarContas(){
		return repository.contarContas();
	}
	
	public List<ContaContabil> selecionarContasRaiz() {
		return repository.selecionarContasRaiz();
	}
	
	public List<Map<String, Object>> selecionarHierarquia() {
		return repository.selecionarHierarquia();
	}
	
	public Page<ContaContabil> selecionarContasPaginado(Pageable pageable) {
		return repository.selecionarContasPaginado(pageable);
	}
	
	public Slice<ContaContabil> selecionarContasFatiado(Pageable pageable) {
		return repository.selecionarContasFatiado(pageable);
	}

	public List<ContaContabil> recuperarTodasContas(int page, int size) {		
		return repository.recuperarTodasContas(page, size);
	}

}
