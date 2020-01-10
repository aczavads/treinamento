package treinamento.guilhermeperes.dia5.jpa.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.EntityManager;

public abstract class SQLRepository<ENTITY extends BaseEntity, ID> {
	private final EntityManager manager;
	private final Class<?> entityClass;
	private final String entityClassName;
	
	public SQLRepository(EntityManager manager) {
		this.manager = manager;
		this.entityClass = getEntityClass();
		this.entityClassName = entityClass.getSimpleName();
	}
	
	private Class<?> getEntityClass() {
		return (Class<?>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	private String buildSqlString(String... strings) {
		StringBuilder sql = new StringBuilder("");
		
		Stream.of(strings).forEach(string -> sql.append(string));
		
		return sql.toString();
	}
	
	public void save(ENTITY entity) {
		manager.persist(entity);
	}
	
	public void delete(ENTITY entity) {
		manager.remove(entity);
	}
	
	public void deleteById(ID id) {
		String query = buildSqlString("delete from ", entityClassName, " where id = :id");
		
		manager.createQuery(query)
				.setParameter("id", id)
				.executeUpdate();
	}
	
	public void deleteAll() {
		String query = buildSqlString("delete from ", entityClassName);
		
		manager.createQuery(query)
				.executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	public ENTITY findById(ID id) {
		return (ENTITY) manager.find(entityClass, id);
	}
	
	public List<?> findAll() {
		String query = buildSqlString("select e from ", entityClassName, " e");
		
		return manager.createQuery(query)
				.getResultList();
	}
}
