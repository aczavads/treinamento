package fernando_santos.treinamento.dia8.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import fernando_santos.treinamento.dia8.domain.ContaContabil;
import fernando_santos.treinamento.dia8.dto.ContaContabilDTO;
import fernando_santos.treinamento.dia8.exception.CodigoDoContaContabilidadeInvalido;
import fernando_santos.treinamento.dia8.exception.RegistroNaoEncontrado;
import fernando_santos.treinamento.dia8.repository.ContaContabilRepository;

@TransationalService
public class ContaContabilService {
	@Autowired
	private ContaContabilRepository repo;

	public List<ContaContabil> findAll() {
		return repo.findAll();
	}

	public ContaContabil save(ContaContabilDTO nova) {
		ContaContabil contaSuperior = null;
		if (nova.getContaSuperiorId() != null) {
			contaSuperior = findById(nova.getContaSuperiorId());
		}
		ContaContabil novaContaContabil = null;

		UUID contaSuperiorId = nova.getContaSuperiorId();
		if (!contaSuperiorId.toString().isEmpty()) {
			Optional<ContaContabil> contaSuperiorEncontrada = repo.findById(contaSuperiorId);

			if (contaSuperiorEncontrada.isPresent()) {
				String codigoSuperior = contaSuperiorEncontrada.get().getCodigo();
				if (!codigoSuperior.contains(".")) {
					codigoSuperior = codigoSuperior.concat(".");
				}
				String codigoFilho = nova.getCodigo();
				if (!codigoFilho.startsWith(codigoSuperior)) {
					throw new CodigoDoContaContabilidadeInvalido();
				}
			}

		}

		if (nova.getId() == null) {
			novaContaContabil = new ContaContabil(nova.getCodigo(), nova.getNome(), contaSuperior);
		} else {
			novaContaContabil = new ContaContabil(nova.getId(), nova.getCodigo(), nova.getNome(), contaSuperior);
		}
		return repo.save(novaContaContabil);
	}

	public ContaContabil findById(UUID id) {
		return repo.findById(id).orElseThrow(() -> new RegistroNaoEncontrado("Conta contábil: " + id));
	}

	public List<Map<String, Object>> recuperarHierarquia() {
		return repo.recuperarHierarquia();
	}

	public Page<ContaContabil> recuperarTodasPaginado(Pageable pageable) {
		return repo.findAll(pageable);
	}

	public Slice<ContaContabil> recuperarTodasPaginadoComSlice(Pageable pageable) {
		return repo.findAll(pageable);
	}

	public List<ContaContabil> recuperarTodasPaginadoManualmente(int page, int size) {
		return repo.recuperarTodasPaginadoManualmente(page, size);
	}

	public List<ContaContabil> findContasDoPlanoDeContas(UUID id) {
//		return repo.findById(id).get().getContasFilhas();
		return repo.findContasDoPlanoDeContas(id);
	}

	public void deleteById(UUID idContaContabil) {
		repo.deleteById(idContaContabil);
	}
}
