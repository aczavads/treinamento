package valdenir.junior.dia7.conta_contabil;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import valdenir.junior.dia7.NumeroInvalidoException;
import valdenir.junior.dia7.RegistroNaoEncontrato;

@Service
@Transactional
public class ContaContabilsService {
	@Autowired
	private ContaContabilsRepository repo;

	public List<ContaContabils> findAll() {
		return repo.findAll();
	}

	public ContaContabils safe(ContaContabilsDTO nova) {
		ContaContabils superior = null;
		if (nova.getContaSuperior() != null) {
			superior = repo.findById(nova.getContaSuperior()).get();
		}
		validarCodigoContaContabil(nova, superior);
		ContaContabils novaConta = new ContaContabils(nova.getCodigo(), nova.getNome(), superior);
		return repo.save(novaConta);
	}

	private void validarCodigoContaContabil(ContaContabilsDTO nova, ContaContabils superior) {
		String msgErro = "Código inserido é invalido.";
		if (nova.getCodigo() == null)
			throw new NumeroInvalidoException(msgErro);

		String[] filho = nova.getCodigo().split("\\.");
		if (superior == null && filho.length > 1)
			throw new NumeroInvalidoException(msgErro);
		else if (superior != null) {
			String[] pai = superior.getCodigo().split("\\.");
			if ((pai.length + 1) != filho.length)
				throw new NumeroInvalidoException(msgErro);
			for (int i = 0; i < pai.length; i++) {
				if (!pai[i].equals(filho[i]))
					throw new NumeroInvalidoException(msgErro);
			}
		}
	}

	public ContaContabils findById(UUID id) {
		return repo.findById(id).orElseThrow(() -> new RegistroNaoEncontrato("Conta não encontrada: " + id));
	}

	public List<ContaContabils> selecionarContasRaiz() {
		return repo.selecionarContasRaiz();
	}

	public Long contarContas() {
		return repo.contarContas();
	}

	public List<Map<String, Object>> recuperarHierarquia() {
		return repo.recuperarHierarquia();
	}

	public void delete(UUID id) {
		repo.delete(findById(id));
	}

	public Page<ContaContabils> recuperarTodas(Pageable pageable) {
		return repo.recuperarTodas(pageable);
	}

	public Slice<ContaContabils> recuperarTodasFatiadas(Pageable pageable) {
		return repo.recuperarTodasFatiadas(pageable);
	}

	public List<ContaContabils> recuperarTodasPaginadoManualmente(int page, int size) {
		return repo.recuperarTodasPaginadoManualmente(page, size);
	}
}
