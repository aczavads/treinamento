package treinamento.diegomucheniski.dia7.conta_contabil;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import treinamento.diegomucheniski.annotations.TransactionalService;
import treinamento.diegomucheniski.dia7.exceptions.HierarquiaInvalidaException;
import treinamento.diegomucheniski.dia7.exceptions.RegistroNaoEncontradoMucheniski;

@TransactionalService
public class ContaContabilMucheniskiService {
	
	@Autowired
	private ContaContabilMucheniskiRepository repository;
	
	public List<ContaContabilMucheniski> findAll() {
		return repository.findAll();
	}
	
	public ContaContabilMucheniski save(ContaContabilMucheniskiDTO novaContaDTO) {
		
		ContaContabilMucheniski contaSuperior = null;
		if (novaContaDTO.getContaSuperiorId() != null) {			
			contaSuperior =  repository.findById(novaContaDTO.getContaSuperiorId()).orElseThrow(() -> new RegistroNaoEncontradoMucheniski("Registro não encontrado!"));
				
			String codigoPai = contaSuperior.getCodigo();
			String codigoFilho = novaContaDTO.getCodigo();
			
			if (ehCodigoComPai(codigoPai, codigoFilho) && ehPontoOProximoDigito(codigoPai, codigoFilho)) {				
				ContaContabilMucheniski novaConta = null;
				if (novaContaDTO.getId() == null) {
					novaConta = new ContaContabilMucheniski(novaContaDTO.getCodigo(), novaContaDTO.getNome(), contaSuperior);	
				}
				else {			
					novaConta = new ContaContabilMucheniski(novaContaDTO.getId(), novaContaDTO.getCodigo(), novaContaDTO.getNome(), contaSuperior);	
				}				 	
				return repository.save(novaConta);				
			} 			
		}		
		throw new HierarquiaInvalidaException("Código passado sem pai");

	}
	
	private static boolean ehCodigoComPai(String codigoPai, String codigoFilho) {
		String codigoComparado = codigoFilho.substring(0, codigoPai.length());
		if (codigoComparado.equals(codigoPai)) {
			return true;
		}	
		return false;	
	}
	
	private static boolean ehPontoOProximoDigito(String codigoPai, String codigoFilho) {		
		if ((codigoFilho.substring(codigoPai.length(), codigoPai.length()+1)).equals(".")) {
			return true;
		}		
		return false;
	}
	
	public Optional<ContaContabilMucheniski> findById(UUID id) {
		return repository.findById(id);
	}
	
	public Long contarContas(){
		return repository.contarContas();
	}
	
	public List<ContaContabilMucheniski> selecionarContasRaiz() {
		return repository.selecionarContasRaiz();
	}
	
	List<Map<String, Object>> selecionarHierarquia() {
		return repository.selecionarHierarquia();
	}
	
	public Page<ContaContabilMucheniski> selecionarContasPaginado(Pageable pageable) {
		return repository.selecionarContasPaginado(pageable);
	}
	
	public Slice<ContaContabilMucheniski> selecionarContasFatiado(Pageable pageable) {
		return repository.selecionarContasFatiado(pageable);
	}

	public List<ContaContabilMucheniski> recuperarTodasContas(int page, int size) {		
		return repository.recuperarTodasContas(page, size);
	}

}
