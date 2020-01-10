package treinamento.dia4.jdbc.repo_generico.fernando.santos.repository;

import java.sql.SQLException;
import java.util.List;

import treinamento.dia4.jdbc.repo_generico.fernando.santos.domain.BaseEntity;

public interface Repositoty<T extends BaseEntity> {

	List<T> getAll() throws SQLException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, InstantiationException;

	T findById(Long id);

	T save(T object);

	void remove(Long id);

}
