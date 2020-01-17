package schiavon.gabriel.dia7.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import schiavon.gabriel.dia5.jpa.associacoes.BaseEntity;
import schiavon.gabriel.dia7.conta_contabil.exceptions.RegistroNaoEncontrado;

public class BaseService<ID, ENTIDADE extends BaseEntity<ID>, DTO extends BaseDTO<ID, ENTIDADE>, REPOSITORY extends BaseRepository<ID, ENTIDADE>> {

	@Autowired
	protected REPOSITORY repository;

	public Slice<ENTIDADE> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public List<ENTIDADE> recuperarTodasManual(int page, int size) {
		return null;
	}
	
	public ENTIDADE findById(ID id) {
		return repository
				.findById(id)
				.orElseThrow(() -> new RegistroNaoEncontrado(
						"Registro não encontrado: " + id));
	}
	
	public Long getQuantidade() {
		return repository.count();
	}
	
	public void remover(ID id) {
		ENTIDADE entidade = findById(id);
		repository.delete(entidade);
	}
	
	public ENTIDADE save(DTO dto) {
		ENTIDADE paraSalvar = dto.toEntity();
		paraSalvar = beforeSave(dto, paraSalvar);
		return repository.save(paraSalvar);
	}
	
	public void update(ID id, DTO dto) {
		ENTIDADE recuperado = findById(dto.getId());
		ENTIDADE paraSalvar = dto.mergeEntity(recuperado);
		paraSalvar = beforeUpdate(dto, paraSalvar);
		repository.save(paraSalvar);
	}

	public ENTIDADE beforeUpdate(DTO dto, ENTIDADE paraSalvar) {
		return paraSalvar;
	}
	
	public ENTIDADE beforeSave(DTO dto, ENTIDADE paraSalvar) {
		return paraSalvar;
	}
	
}
