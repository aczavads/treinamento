package william.dia7.Conta_Contabilwd;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ContaContabilService {
	@Autowired
	private ContaContabilRepository repository;

	public List<ContaContabil> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	public void save(ContaContabil contaContabil) {
		repository.save(contaContabil);
	}

	public ContaContabil findById(UUID id) {

		return repository.
				findById(id).orElseThrow(() -> new ContaNãoEncontrada("Registro não encontrado!"));
	}

	public Long contarContas() {
		// TODO Auto-generated method stub
		return repository.contarContas();
	}

	public List<ContaContabil> contasRaiz() {
		// TODO Auto-generated method stub
		return repository.selecionarContasRaiz();
	}

	public List<Map<String, Object>> hierarquia() {
		// TODO Auto-generated method stub
		return repository.recuperarHierarquia();
	}
	
	public ContaContabil save(ContaContabilDTO nova) {
		
		
		ContaContabil contaSuperior = null;
		ContaContabil novaContabil = null;
		if (nova.getContaSuperiorId() != null) {
			contaSuperior = findById(nova.getContaSuperiorId());
			if (!verificaContaSuperior(nova.getCodigo(), contaSuperior.getCodigo() )) {
				throw new CodigoInvalido("Código Inválido!");
			}
		}
		if (nova.getId() != null) {
			if (repository.existsById(nova.getId())) {
				throw new ContaExistente("Conta existente no banco de dados!");
			}
			novaContabil =  new ContaContabil(
					nova.getId(),
					nova.getCodigo(),
					nova.getNome(),
					contaSuperior);
		} else {
			novaContabil =  new ContaContabil(
					nova.getCodigo(),
					nova.getNome(),
					contaSuperior);
		}
		 return repository.save(novaContabil);
	}

	private boolean verificaContaSuperior(String nova, String superior) {
		String subCodigoNova = nova.substring(0, superior.length());
		System.out.println("substring ----------->"+subCodigoNova);
		System.out.println("Pai ----------->"+ superior);
		return superior.equals(subCodigoNova);
	}
	
	public Page<ContaContabil> recuperarTodas(Pageable pageable){
		return repository.recuperarTodas(pageable);
	}
	
	public Slice<ContaContabil> recuperarTodasFatiada(Pageable pageable){
		return repository.recuperarTodasFatiada(pageable);
	}

	public List<ContaContabil> recuperarTodasManual(int page, int size) {
		// TODO Auto-generated method stub
		return repository.recuperarTodasManual(page, size);
	}

}
