package treinamento.dia4.jdbc.repo_generico.fernando.santos.repository.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import treinamento.dia4.fernando.santos.jdbc.repository.Pessoa;
import treinamento.dia4.jdbc.repo_generico.fernando.santos.ConnectionPool;
import treinamento.dia4.jdbc.repo_generico.fernando.santos.domain.BaseEntity;
import treinamento.dia4.jdbc.repo_generico.fernando.santos.repository.Repositoty;

public abstract class AbstractRepositoryImpl<T extends BaseEntity> implements Repositoty<T> {
	
	private Class<T> clazz;
	private final Connection connection;
	
	private Field[] fields;
	private String selectAllQuery;

	public AbstractRepositoryImpl(Class<T> clazz) {
		if (clazz == null) {
			throw new IllegalArgumentException("Clazz is mandatory.");
		}
		this.clazz = clazz;
		
		if(fields == null) {
			this.fields = getAllFields();
		}
		
		try {
			this.connection = new ConnectionPool().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public List<T> getAll() throws SQLException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, InstantiationException {
		if(selectAllQuery == null) {
			selectAllQuery = getSelectAllQuery();
		}
		ResultSet rs = connection.createStatement().executeQuery(selectAllQuery);
		
		List<T> objects = new ArrayList<>();
		while(rs.next()) {
			
			T object = clazz.newInstance();
			
			for(int i = 0; i < fields.length; i++) {
				Object fieldValue = rs.getObject(i);
				Field field = clazz.getDeclaredField(fields[i].getName());
				field.setAccessible(true);
				field.set(object, fieldValue);
			}
			
			objects.add(object);
		}
		
		return objects;
	}

	private String getSelectAllQuery() {
		String select = "select";
		try {
			String nomeDaTabela = clazz.getSimpleName().toLowerCase();
			select += " " + gerarStringDeCampos(clazz, true);
			select += " from " + nomeDaTabela;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return select;
		
	}
 
	@Override
	public T findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T save(T object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	private String gerarStringDeCampos(Class<T> classe, boolean nomesDosCampos) {
		String stringDeCampos = "";
		for (Field field : fields) {
			if (nomesDosCampos) {
				stringDeCampos += field.getName().toLowerCase() + ",";
			} else {
				stringDeCampos += "?,";
			}
		}
		stringDeCampos = stringDeCampos.substring(0, stringDeCampos.length()-1); //removendo última vírgula...
		return stringDeCampos;
	}
	
	private Field[] getAllFields() {
		Field[] camposDaSuperclasse = clazz.getSuperclass().getDeclaredFields();
		Field[] camposDaClasse =  clazz.getDeclaredFields();
		List<Field> allFields = new ArrayList<>();
		allFields.addAll(Arrays.asList(camposDaSuperclasse));
		allFields.addAll(Arrays.asList(camposDaClasse));
		return allFields.toArray(new Field[] {});
	}

}
