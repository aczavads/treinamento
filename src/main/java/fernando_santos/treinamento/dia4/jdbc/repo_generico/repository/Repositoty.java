package fernando_santos.treinamento.dia4.jdbc.repo_generico.repository;

import java.sql.SQLException;
import java.util.List;

import fernando_santos.treinamento.dia4.jdbc.repo_generico.domain.BaseEntity;

public interface Repositoty<T extends BaseEntity> {

	List<T> getAll() throws SQLException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, InstantiationException;

	T findById(Long id);

	T save(T object);

	void remove(Long id);

}
