package treinamento.dia7.conta_contabil2.fernando.santos;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

@TransationalService
public class ContaContabilService {
	@Autowired
	private ContaContabilRepository repo;

	public List<ContaContabilFS2> findAll() {
		return repo.findAll();
	}

	public ContaContabilFS2 save(ContaContabilDTO nova) {
		ContaContabilFS2 contaSuperior = null;
		if (nova.getContaSuperiorId() != null) {
			contaSuperior = findById(nova.getContaSuperiorId());
		}
		ContaContabilFS2 novaContaContabil = null;

		UUID contaSuperiorId = nova.getContaSuperiorId();
		if (!contaSuperiorId.toString().isEmpty()) {
			Optional<ContaContabilFS2> contaSuperiorEncontrada = repo.findById(contaSuperiorId);

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
			novaContaContabil = new ContaContabilFS2(nova.getCodigo(), nova.getNome(), contaSuperior);
		} else {
			novaContaContabil = new ContaContabilFS2(nova.getId(), nova.getCodigo(), nova.getNome(), contaSuperior);
		}
		return repo.save(novaContaContabil);
	}

	public ContaContabilFS2 findById(UUID id) {
		return repo.findById(id).orElseThrow(() -> new RegistroNaoEncontrado("Conta cont�bil: " + id));
	}

	public List<Map<String, Object>> recuperarHierarquia() {
		return repo.recuperarHierarquia();
	}

	public Page<ContaContabilFS2> recuperarTodasPaginado(Pageable pageable) {
		return repo.findAll(pageable);
	}

	public Slice<ContaContabilFS2> recuperarTodasPaginadoComSlice(Pageable pageable) {
		return repo.findAll(pageable);
	}

	public List<ContaContabilFS2> recuperarTodasPaginadoManualmente(int page, int size) {
		return repo.recuperarTodasPaginadoManualmente(page, size);
	}
}
