package schiavon.gabriel.dia7.conta_contabil;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
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
			contaSuperior = findById(novaContaDTO.getContaSuperiorId()).orElseThrow(() -> new RegistroNaoEncontrado(
					"Conta superior não existente: " + novaContaDTO.getContaSuperiorId()));
		}
		
		validaDadosEntrada(novaContaDTO, contaSuperior);
		MyContaContabil novaConta;
		if (novaContaDTO.getId() == null) {
			novaConta = new MyContaContabil(novaContaDTO.getCodigo(), novaContaDTO.getNome(), contaSuperior);
		} else {
			novaConta = new MyContaContabil(novaContaDTO.getId(), novaContaDTO.getCodigo(), novaContaDTO.getNome(),
					contaSuperior);
		}
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
			throw new CodigoDoFilhoNaoPertenceAoPaiException("O código do filho não bate com código do pai");
		}
	}

	public Optional<MyContaContabil> findById(UUID id) {
		return contaContabilRepository.findById(id);
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

	public void remover(UUID id) {
		MyContaContabil contaContabil = contaContabilRepository.findById(id).orElseThrow(() -> new RegistroNaoEncontrado("Conta contabil não encontrada."));
		contaContabilRepository.delete(contaContabil);
	}
}
