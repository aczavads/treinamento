package schiavon.gabriel.dia7.planoDeContas;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import schiavon.gabriel.dia7.TransationalService;
import schiavon.gabriel.dia7.conta_contabil.MyContaContabil;
import schiavon.gabriel.dia7.conta_contabil.MyContaContabilRepository;
import treinamento.dia7.conta_contabil.RegistroNaoEncontrado;

@TransationalService
public class MyPlanoDeContasService {

	@Autowired
	private MyPlanoDeContasRepository repository;

	@Autowired
	private MyContaContabilRepository contabilRepository;

	public MyPlanoDeContas save(MyPlanoDeContasDTO myPlanoDeContasDTO) {
		MyPlanoDeContas myPlanoDeContas = null;
		if (myPlanoDeContasDTO.getId() == null) {
			myPlanoDeContas = new MyPlanoDeContas(myPlanoDeContasDTO.getDescricao(),
					myPlanoDeContasDTO.getInicioVigencia(), myPlanoDeContasDTO.getTerminoVigencia());
		} else {
			myPlanoDeContas = new MyPlanoDeContas(myPlanoDeContasDTO.getId(), myPlanoDeContasDTO.getDescricao(),
					myPlanoDeContasDTO.getInicioVigencia(), myPlanoDeContasDTO.getTerminoVigencia());
		}

		return repository.save(myPlanoDeContas);
	}

	public List<MyPlanoDeContas> findAll() {
		return repository.findAll();
	}

	public void adicionarContas(UUID idPlano, List<UUID> idsContasParaAdicionar) {
		MyPlanoDeContas planoDeContas = repository.findById(idPlano)
				.orElseThrow(() -> new RegistroNaoEncontrado("Plano de contas não encontrado"));
		List<MyContaContabil> contasContabil = contabilRepository.findAllById(idsContasParaAdicionar);
		contasContabil.forEach(conta -> {
			planoDeContas.adicionar(conta);
		});
	}

	public Set<MyContaContabil> getAllContasPlano(UUID idPlano) {
		Set<MyContaContabil> recuperarTodasContasVinculadasAoPlanoDeContas = contabilRepository
				.recuperarTodasContasVinculadasAoPlanoDeContas(idPlano);
		return recuperarTodasContasVinculadasAoPlanoDeContas;
	}

	public void deletarPlano(UUID idPlano) {
		MyPlanoDeContas planoDeContas = repository.findById(idPlano)
				.orElseThrow(() -> new RegistroNaoEncontrado("Plano de contas não encontrado"));
		repository.delete(planoDeContas);
	}

	public void deletarContasDoPlano(UUID idPlano, List<UUID> idsContasParaRemover) {
		MyPlanoDeContas planoDeContas = repository.findById(idPlano)
				.orElseThrow(() -> new RegistroNaoEncontrado("Plano de contas não encontrado"));
		List<MyContaContabil> contasContabil = contabilRepository.findAllById(idsContasParaRemover);
		contasContabil.forEach(conta -> {
			planoDeContas.remover(conta);
		});
	}
}
