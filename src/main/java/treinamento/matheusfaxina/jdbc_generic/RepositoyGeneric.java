package treinamento.matheusfaxina.jdbc_generic;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class RepositoyGeneric<ENTIDADE extends Entidade> {
	
	private Class<? extends Entidade> classeDaEntidade;
	private Connection conn;

	public RepositoyGeneric(Connection conn, Class<? extends Entidade> classeDaEntidade) {
		this.conn = conn;
		this.classeDaEntidade = classeDaEntidade;
	}
	
	public void delete(UUID id) {

	}

	public List<ENTIDADE> selecAll() {
		return new ArrayList<ENTIDADE>();
	}

	public void insert(ENTIDADE entidade) {
		System.out.println(gerarInsertDe(classeDaEntidade));
	}
	
	private String gerarUpdateDe(Class<ENTIDADE> classe) {
		String update = "UPDATE ";
		try {
			String nomeDaTabela = classe.getSimpleName().toLowerCase();
			Field[] campos = classe.getDeclaredFields();
			update += nomeDaTabela + " SET ";
			for (Field field : campos) {
				update += field.getName().toLowerCase() + " = ?,";
			}
			update = update.substring(0, update.length() - 1);
			String nomeDoId = Arrays.stream(classe.getDeclaredFields())
					.filter(f -> f.isAnnotationPresent(ChavePrimaria.class)).findFirst().get().getName().toLowerCase();
			update += " WHERE " + nomeDoId + " ?";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return update;
	}

	private String gerarInsertDe(Class<? extends Entidade> classeDaEntidade2) {
		String insert = "INSERT INTO ";
		try {
			String nomeDaTabela = classeDaEntidade2.getSimpleName().toLowerCase();
			Field[] campos = classeDaEntidade2.getDeclaredFields();
			insert += nomeDaTabela + "(";
			for (Field field : campos) {
				insert += field.getName().toLowerCase() + ",";
			}
			insert = insert.substring(0, insert.length() - 1);
			String values = "";
			for (int i = 0; i < campos.length; i++) {
				values += "?, ";
			}
			values = values.substring(0, values.length() - 2);
			insert += ") VALUES(" + values + ")";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return insert;
	}
	
	private String gerarDeleteDe(Class<ENTIDADE> classe) {
		String delete = "DELETE ";
		try {
			String nomeDaTabela = classe.getSimpleName().toLowerCase();
			delete += nomeDaTabela + " WHERE ";
			String nomeDoId = Arrays.stream(classe.getDeclaredFields()).filter(f -> f.isAnnotationPresent(ChavePrimaria.class))
					.findFirst().get().getName().toLowerCase();
			delete += nomeDoId + " = ?";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return delete;
	}

	private String gerarSelectDe(Class<ENTIDADE> classe) {
		String select = "SELECT ";
		try {
			String nomeDaTabela = classe.getSimpleName().toLowerCase();
			Field[] campos = classe.getDeclaredFields();
			for (Field field : campos) {
				select += field.getName().toLowerCase() + ",";
			}
			select = select.substring(0, select.length() - 1);
			select += " from " + nomeDaTabela;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return select;
	}
	
	private Field[] getAllFields(Class<? extends Entidade> classe) {
		Field[] camposDaSuperClasse = classe.getSuperclass().getDeclaredFields();
		Field[] camposDaClasse = classe.getDeclaredFields();
		List<Field> allFields = new ArrayList<>();
		allFields.addAll(Arrays.asList(camposDaClasse));
		allFields.addAll(Arrays.asList(camposDaSuperClasse));
		return allFields.toArray(new Field[] {});
		
		
	}

}
