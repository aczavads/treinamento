package william.dia10.ContaContabil;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ContaContabilService extends BaseService<ContaContabil, ContaContabilDTO, ContaContabilRepository> {
	@Autowired
	private ContaContabilRepository repository;

	public List<ContaContabil> findAll() {
		return repository.findAll();
	}
	
	@Override
	public ContaContabil save(ContaContabilDTO dto) {
		ContaContabil contaContabilSuperior = null;
		if (dto.getContaSuperiorId() != null) {
			contaContabilSuperior = findById(dto.getContaSuperiorId());
		}
		ContaContabil contaContabil = ContaContabil.builder()
				.codigo(dto.getCodigo())
				.contaSuperior(contaContabilSuperior)
				.version(dto.getVersion())
				.nome(dto.getNome())
				.build();
		return repository.save(contaContabil);
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

	private boolean verificaContaSuperior(String nova, String superior) {
		String subCodigoNova = nova.substring(0, superior.length());
		System.out.println("substring ----------->" + subCodigoNova);
		System.out.println("Pai ----------->" + superior);
		return superior.equals(subCodigoNova);
	}



	public List<ContaContabil> findAllById(List<Long> idsDasContasParaAdicionar) {
		return repository.findAllById(idsDasContasParaAdicionar);
	}

	public void update(ContaContabilDTO dto) {
		ContaContabil contaSuperior = findByIdOrNull(dto);
		ContaContabil nova = ContaContabil.builder().codigo(dto.getCodigo()).id(dto.getId()).nome(dto.getNome())
				.contaSuperior(contaSuperior).version(dto.getVersion()).build();
		repository.save(nova);
	}

	private ContaContabil findByIdOrNull(ContaContabilDTO dto) {
		if (dto.getContaSuperiorId() != null) {
			return findById(dto.getContaSuperiorId());
		}
		return null;
	}

}
