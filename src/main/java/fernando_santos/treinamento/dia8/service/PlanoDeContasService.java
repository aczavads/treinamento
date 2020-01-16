package fernando_santos.treinamento.dia8.service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import fernando_santos.treinamento.dia8.domain.ContaContabil;
import fernando_santos.treinamento.dia8.domain.PlanoDeContas;
import fernando_santos.treinamento.dia8.dto.PlanoDeContasDTO;
import fernando_santos.treinamento.dia8.exception.RegistroNaoEncontrado;
import fernando_santos.treinamento.dia8.repository.ContaContabilRepository;
import fernando_santos.treinamento.dia8.repository.PlanoDeContasRepository;

@Service
@Transactional
public class PlanoDeContasService {

	@Autowired
	private PlanoDeContasRepository planoDeContasRepository;

	@Autowired
	private ContaContabilRepository contaContabilRepository;

	public PlanoDeContas save(PlanoDeContasDTO dto) {
		PlanoDeContas novo = new PlanoDeContas(dto.getId(), dto.getDescricao(), dto.getInicioVigencia(),
				dto.getFimVigencia());
		return planoDeContasRepository.save(novo);
	}

	public List<PlanoDeContas> findAll() {
		return planoDeContasRepository.findAll();
	}

	public void adicionarContas(UUID idDoPlanoDeContas, List<UUID> idsDasContasParaAdicionar) {
		PlanoDeContas plano = planoDeContasRepository.findById(idDoPlanoDeContas)
				.orElseThrow(() -> new RegistroNaoEncontrado("Plano de contas não encontrado!"));
		List<ContaContabil> contasParaAdicionar = contaContabilRepository.findAllById(idsDasContasParaAdicionar);
		if (contasParaAdicionar.size() != idsDasContasParaAdicionar.size()) {
			throw new RegistroNaoEncontrado("Conta contábil não encontrada");
		}
		contasParaAdicionar.forEach(cc -> plano.adicionar(cc));
	}

	public boolean existsById(UUID id) {
		return planoDeContasRepository.existsById(id);
	}

	public void removeContasDoPlanoDeContas(UUID idPlanoDeContas, Set<UUID> idsContasContabeis) {
		if (!planoDeContasRepository.existsById(idPlanoDeContas)) {
			throw new RegistroNaoEncontrado("Plano de contas não encontrado.");
		}
		idsContasContabeis.forEach(conta -> planoDeContasRepository.removeRelacionamentoDaContaDoPlanoDeContas(conta));
	}

	public void removeById(UUID idPlanoDeContas) {
		planoDeContasRepository.deleteById(idPlanoDeContas);
	}

	public void update(PlanoDeContasDTO planoDeContasDTO) {
		PlanoDeContas planoDeContasRecuperado = planoDeContasRepository.findById(planoDeContasDTO.getId())
				.orElseThrow(() -> new RegistroNaoEncontrado("Plano de contas não encontrado."));
		planoDeContasRecuperado.setDescricao(planoDeContasDTO.getDescricao());
		planoDeContasRecuperado.setInicioVigencia(planoDeContasDTO.getInicioVigencia());
		planoDeContasRecuperado.setFimVigencia(planoDeContasDTO.getFimVigencia());
	}

}
