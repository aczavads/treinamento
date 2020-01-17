package schiavon.gabriel.dia7.conta_contabil;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import schiavon.gabriel.dia7.TransationalService;
import schiavon.gabriel.dia7.conta_contabil.exceptions.CodigoDoFilhoNaoPertenceAoPaiException;
import schiavon.gabriel.dia7.conta_contabil.exceptions.RegistroNaoEncontrado;

@TransationalService
public class MyContaContabilService {

	@Autowired
	private MyContaContabilRepository contaContabilRepository;

	public List<MyContaContabil> findAll() {
		return contaContabilRepository.findAll();
	}

	public MyContaContabil save(MyContaContabilDTO novaContaDTO) {
		MyContaContabil contaSuperior = null;
		if (novaContaDTO.getContaSuperiorId() != null) {
			contaSuperior = findById(novaContaDTO.getContaSuperiorId());
		}
		
		validaDadosEntrada(novaContaDTO, contaSuperior);
		MyContaContabil novaConta = MyContaContabil
				.builder()
				.id(novaContaDTO.getId())
				.codigo(novaContaDTO.getCodigo())
				.nome(novaContaDTO.getNome())
				.contaSuperior(contaSuperior)
				.build();
		
		return contaContabilRepository.save(novaConta);
	}

	private void validaDadosEntrada(MyContaContabilDTO novaContaDTO, MyContaContabil contaSuperior) {
		if (contaSuperior != null) {
			verificaCodigoComCodigoPai(novaContaDTO, contaSuperior);
		}
	}

	private void verificaCodigoComCodigoPai(MyContaContabilDTO novaContaDTO, MyContaContabil contaSuperior) {
		Pattern pattern = Pattern.compile("\\.\\d+$");
		String codigoEnviado = pattern.matcher(novaContaDTO.getCodigo()).replaceAll("");
		
		if (!codigoEnviado.equals(contaSuperior.getCodigo())) {
			throw new CodigoDoFilhoNaoPertenceAoPaiException("O c�digo do filho n�o bate com c�digo do pai");
		}
	}

	public MyContaContabil findById(Long id) {
		return contaContabilRepository
				.findById(id)
				.orElseThrow(() -> new RegistroNaoEncontrado(
						"Conta superior n�o existente: " + id));
	}

	public Long getQuantidadeContas() {
		return contaContabilRepository.contarContas();
	}

	public List<MyContaContabil> getContasRaiz() {
		return contaContabilRepository.selecionarContasRaiz();
	}

	public List<Map<String, Object>> getContasRaizPorHierarquia() {
		return contaContabilRepository.selecionarContasPorHierarquia();
	}
	
	public Page<MyContaContabil> recuperarTodas(Pageable pageable) {
		return contaContabilRepository.recuperarTodas(pageable);
	}
	
	public Slice<MyContaContabil> recuperarTodasFatiado(Pageable pageable) {
		return contaContabilRepository.recuperarTodasFateadas(pageable);
	}

	public List<MyContaContabil> recuperarTodasManual(int page, int size) {
		return contaContabilRepository.recuperarTodasManual(page, size);
	}

	public void remover(Long id) {
		MyContaContabil contaContabil = contaContabilRepository.findById(id).orElseThrow(() -> new RegistroNaoEncontrado("Conta contabil n�o encontrada."));
		contaContabilRepository.delete(contaContabil);
	}

	public void alterarDadosPlano(Long id, MyContaContabilDTO contaContabilDTO) {
		MyContaContabil contaContabil = findById(id);
		MyContaContabil contaSuperior = findContaSuperiorOrNull(contaContabilDTO.getId());
		contaContabil.setCodigo(contaContabilDTO.getCodigo());
		contaContabil.setNome(contaContabilDTO.getNome());
		contaContabil.setContaSuperior(contaSuperior);
	}

	private MyContaContabil findContaSuperiorOrNull(Long idContaSuperior) {
		if (idContaSuperior != null) {
			return findById(idContaSuperior);
		}
		
		return null;
	}
}
