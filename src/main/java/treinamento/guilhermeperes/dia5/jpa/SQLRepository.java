package treinamento.guilhermeperes.dia5.jpa;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.Id;

public abstract class SQLRepository<ENTITY, ID> {
	private final EntityManager manager;
	private final Class<?> entityClass;
	private final String entityClassName;
	private final String entityIdName;
	
	public SQLRepository(EntityManager manager) {
		this.manager = manager;
		this.entityClass = getEntityClass();
		this.entityClassName = entityClass.getSimpleName();
		this.entityIdName = getEntityIdField().getName();
	}
	
	private Class<?> getEntityClass() {
		return (Class<?>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	private Field getEntityIdField() {
		Optional<Field> idField = Stream.of(entityClass.getDeclaredFields())
				.filter(field -> field.getDeclaredAnnotation(Id.class) != null)
				.findFirst();
		
		if (idField.isPresent()) {
			return idField.get();
		}
		
		return null;
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
		String query = buildSqlString("delete from ", entityClassName, " where ", entityIdName, " = :id");
		
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
