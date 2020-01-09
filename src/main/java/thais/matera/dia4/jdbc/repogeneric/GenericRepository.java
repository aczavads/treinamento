package thais.matera.dia4.jdbc.repogeneric;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class GenericRepository<ENTITY extends Entity> {
	private Class<ENTITY> entityClass;
	private Connection conn;
	
	public GenericRepository(Connection conn, Class<ENTITY> entityClass) {
		this.entityClass = entityClass;
		this.conn = conn;
	}
	
	public void delete(UUID id) {
		
	}
	
	public List<ENTITY> selectAll() {
		return new ArrayList<ENTITY>();
	}

	public void insert(ENTITY object) {
		String insert = generateInsertOf(entityClass);
		
		try(PreparedStatement psInsert = conn.prepareStatement(insert)) {
			Field[] fields = getAllFields(entityClass);
			
			for(int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				field.setAccessible(true);
				Object value = field.get(object);
				field.setAccessible(false);
				psInsert.setObject(i+1, value);
			}
			psInsert.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(insert);
	}
	
	private String generateInsertOf(Class<ENTITY> classSelected) {
		String insert = "insert into ";
		
		try {
			String tableName = classSelected.getSimpleName().toLowerCase();
			insert += tableName + " (";
			insert += generateFields(classSelected, true);
			insert += ") values (" + generateFields(classSelected, false) + ")";
 		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return insert;
	}

	private String generateDeleteOf(Class<ENTITY> classSelected) {
		String delete = "delete from ";
		
		try {
			String tableName = classSelected.getSimpleName().toLowerCase();
			delete += tableName + " where ";
			String idName = Arrays.stream(classSelected.getDeclaredFields())
				.filter(f -> f.isAnnotationPresent(PrimaryKey.class))
				.findFirst().get().getName().toLowerCase();
			delete += idName + " = ?";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return delete;
	}
	
	private String generateSelectOf(Class<ENTITY> classSelected) {
		String select = "select ";
		
		try {
			String tableName = classSelected.getSimpleName().toLowerCase();
			select += " " + generateFields(classSelected, true);
			select += " from " + tableName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return select;
	}
	
	private String generateFields(Class<ENTITY> classSelected, boolean fieldName) {
		String fieldsString = "";
		
		Field[] fields = getAllFields(classSelected);
		
		for(Field field: fields) {
			if(fieldName) {
				fieldsString += field.getName().toLowerCase() + ",";
			}else {
				fieldsString += "?,";				
			}
		}
		
		fieldsString = fieldsString.substring(0, fieldsString.length()-1);
		
		return fieldsString;
	}
	
	private Field[] getAllFields(Class<ENTITY> classSelected) {
		
		Field[] fieldsMother = classSelected.getSuperclass().getDeclaredFields();
		Field[] fields = classSelected.getDeclaredFields();
		
		List<Field> allFields = new ArrayList<>();
		allFields.addAll(Arrays.asList(fieldsMother));
		allFields.addAll(Arrays.asList(fields));
		
		return allFields.toArray(new Field[] {});
	}

}
