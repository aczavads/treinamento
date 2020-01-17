package schiavon.gabriel.dia7.planoDeContas;

import java.util.List;
import java.util.Set;

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
		MyPlanoDeContas myPlanoDeContas = MyPlanoDeContas.builder().id(myPlanoDeContasDTO.getId())
				.descricao(myPlanoDeContasDTO.getDescricao()).inicioVigencia(myPlanoDeContasDTO.getInicioVigencia())
				.terminoVigencia(myPlanoDeContasDTO.getTerminoVigencia()).build();

		return repository.save(myPlanoDeContas);
	}

	public List<MyPlanoDeContas> findAll() {
		return repository.findAll();
	}

	public Set<MyContaContabil> getAllContasPlano(Long idPlano) {
		return contabilRepository.recuperarTodasContasVinculadasAoPlanoDeContas(idPlano);
	}

	public void deletarPlano(Long idPlano) {
		MyPlanoDeContas planoDeContas = findById(idPlano);
		repository.delete(planoDeContas);
	}

	public MyPlanoDeContas findById(Long idPlano) {
		return repository.findById(idPlano)
				.orElseThrow(() -> new RegistroNaoEncontrado("Plano de contas não encontrado"));
	}

	public void adicionarContas(Long idPlano, List<Long> idsContasParaAdicionar) {
		MyPlanoDeContas planoDeContas = findById(idPlano);
		List<MyContaContabil> contasContabil = getContasContabeis(idsContasParaAdicionar);
		contasContabil.forEach(conta -> {
			planoDeContas.adicionar(conta);
		});
	}

	public void deletarContasDoPlano(Long idPlano, List<Long> idsContasParaRemover) {
		MyPlanoDeContas planoDeContas = findById(idPlano);
		List<MyContaContabil> contasContabil = getContasContabeis(idsContasParaRemover);
		contasContabil.forEach(conta -> {
			planoDeContas.remover(conta);
		});
	}

	private List<MyContaContabil> getContasContabeis(List<Long> idsContasParaBuscar) {
		List<MyContaContabil> contasContabeisRecuperadas = contabilRepository.findAllById(idsContasParaBuscar);
		if (contasContabeisRecuperadas.size() != idsContasParaBuscar.size()) {
			throw new RegistroNaoEncontrado("Conta contábil não encontrada");
		}

		return contasContabeisRecuperadas;
	}

	public void alterarDadosPlano(Long id, MyPlanoDeContasDTO myPlanoDeContasDTO) {
		MyPlanoDeContas planoDeContas = findById(myPlanoDeContasDTO.getId());
		planoDeContas.setDescricao(myPlanoDeContasDTO.getDescricao());
		planoDeContas.setInicioVigencia(myPlanoDeContasDTO.getInicioVigencia());
		planoDeContas.setTerminoVigencia(myPlanoDeContasDTO.getTerminoVigencia());
	}
}
