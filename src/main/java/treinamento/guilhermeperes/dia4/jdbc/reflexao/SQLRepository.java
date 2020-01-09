package treinamento.guilhermeperes.dia4.jdbc.reflexao;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class SQLRepository<ENTITY, ID> {
	private final Connection database = DatabaseConnection.getConnection();
	
	private Class<?> getEntityClass() {
		return (Class<?>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	private String getEntityName() {
		return getEntityClass().getSimpleName();
	}
	
	private Stream<Field> getEntityFields() {
		return Stream.of(getEntityClass().getDeclaredFields());
	}
	
	private List<Field> getEntityFieldsAsList() {
		return getEntityFields().collect(Collectors.toList());
	}
	
	private String getEntityFieldsAsString() {
		String fields = getEntityFields()
				.map(field -> field.getName() + ",")
				.reduce("", (acc, field) -> acc + field);
		
		return fields.substring(0, fields.length() - 1);
	}
	
	private String getEntityFieldsAsPlaceholders() {
		String fields = getEntityFields()
				.map(field -> "?,")
				.reduce("", (acc, field) -> acc + field);
		
		return fields.substring(0, fields.length() - 1);
	}
	
	private String getEntityFieldsAsKeyPlaceholders(ENTITY entity) {
		String fields = getEntityFields()
				.filter(field -> field.getDeclaredAnnotation(Id.class) == null)
				.map(field -> field.getName() + "=?, ")
				.reduce("", (acc, field) -> acc + field);
		
		return fields.substring(0, fields.length() - 2);
	}
	
	private Field getEntityIdField() {
		Optional<Field> idField = getEntityFields()
				.filter(field -> field.getDeclaredAnnotation(Id.class) != null)
				.findFirst();
		
		if (idField.isPresent()) {
			return idField.get();
		}
		
		return null;
	}
	
	private List<Field> getEntityFieldsAsListWithoutId() {
		return getEntityFields()
				.filter(field -> field.getDeclaredAnnotation(Id.class) == null)
				.collect(Collectors.toList());
	}
	
	private String getEntityIdFieldName() {
		return getEntityIdField().getName().toString();
	}
	
	private Object getIdFieldValue(ENTITY entity) {
		Field field = getEntityIdField();
		Object fieldIdValue = null;
		
		try {
			field.setAccessible(true);
			fieldIdValue = field.get(entity);
			field.setAccessible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return fieldIdValue;
	}
	
	@SuppressWarnings("unchecked")
	private ENTITY createEntityObject() {
		ENTITY entity = null;
		try {
			entity = (ENTITY) getEntityClass().getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return entity;
	}
	
	private String buildSqlString(String... strings) {
		StringBuilder sql = new StringBuilder("");
		
		Stream.of(strings).forEach(string -> sql.append(string));
		
		return sql.toString();
	}
	
	public void insertOne(ENTITY entity) throws SQLException {
		PreparedStatement insert = database.prepareStatement(buildSqlString(
				"INSERT INTO ",
				getEntityName(),
				" VALUES (",
				getEntityFieldsAsPlaceholders(),
				")"
			));
		
		int fieldIndex = 0;
		for (Field field : getEntityFieldsAsList()) {
			try {
				fieldIndex++;
				field.setAccessible(true);
				insert.setObject(fieldIndex, field.get(entity));
				field.setAccessible(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		insert.execute();
	}
	
	public void updateById(ENTITY entity) throws SQLException {
		PreparedStatement update = database.prepareStatement(buildSqlString(
				"UPDATE ",
				getEntityName(),
				" SET ",
				getEntityFieldsAsKeyPlaceholders(entity),
				" WHERE ",
				getEntityIdFieldName(),
				" = ? LIMIT 1"
			));
		
		int fieldIndex = 0;
		for (Field field : getEntityFieldsAsListWithoutId()) {
			try {
				fieldIndex++;
				field.setAccessible(true);
				update.setObject(fieldIndex, field.get(entity));
				field.setAccessible(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		update.setObject(fieldIndex + 1, getIdFieldValue(entity));
		update.execute();
	}
	
	public void deleteById(ID id) throws SQLException {
		PreparedStatement delete = database.prepareStatement(buildSqlString(
				"DELETE FROM ",
				getEntityName(),
				" WHERE ",
				getEntityIdFieldName(),
				" = ? LIMIT 1"
			));
		
		delete.setObject(1, id);
		delete.execute();
	}
	
	public ENTITY selectById(ID id) throws SQLException {
		PreparedStatement select = database.prepareStatement(buildSqlString(
				"SELECT ",
				getEntityFieldsAsString(),
				" FROM ",
				getEntityName(),
				" WHERE ",
				getEntityIdFieldName(),
				" = ?"
			));
		
		select.setObject(1, id);
		ResultSet result = select.executeQuery();
		
		if (result.next()) {
			ENTITY entity = createEntityObject();
			
			getEntityFields().forEach(field -> {
				try {
					field.setAccessible(true);
					field.set(entity, result.getObject(field.getName()));
					field.setAccessible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			
			return entity;
		}
		
		return null;
	}
	
	public List<ENTITY> selectAll() throws SQLException {
		PreparedStatement select = database.prepareStatement(buildSqlString(
				"SELECT ",
				getEntityFieldsAsString(),
				" FROM ",
				getEntityName()
			));
		
		ResultSet result = select.executeQuery();
		
		List<ENTITY> list = new ArrayList<>();
		
		while(result.next()) {
			try {
				ENTITY entity = createEntityObject();
				
				getEntityFields().forEach(field -> {
					try {
						field.setAccessible(true);
						field.set(entity, result.getObject(field.getName()));
						field.setAccessible(false);
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
				
				list.add(entity);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
}
