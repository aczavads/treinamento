package treinamento.dia4.jdbc.repo_generico.fernando.santos;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class RepositorioGenerico<ENTIDADE extends Entidade> {
	private Class<ENTIDADE> classeDaEntidade;
	private Connection conn;
	private Field[] fields;
	private String insert;


	public RepositorioGenerico(Connection conn, Class<ENTIDADE> classeDaEntidade) {
		this.conn = conn;
		this.classeDaEntidade = classeDaEntidade;
		this.fields = getAllFields(classeDaEntidade);
		this.insert = gerarInsertDe(classeDaEntidade);
		for (Field f: getAllFieldsRecursive(classeDaEntidade, new ArrayList<>())) {
			System.out.println(f.getName());
		}
	}
	
	public void delete(UUID id) {
		
	}
	
	public void insert(ENTIDADE objeto) {
		try (PreparedStatement psInsert = conn.prepareStatement(insert)) {
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				field.setAccessible(true);
				Object value = field.get(objeto);
				field.setAccessible(false);
				psInsert.setObject(i+1, value);
			}
			psInsert.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(insert);
	}
	
	public List<ENTIDADE> selectAll() {
		return new ArrayList<ENTIDADE>();
	}
	
	private String gerarInsertDe(Class<ENTIDADE> classe) {
		String insert = "insert into ";
		try {
			String nomeDaTabela = classe.getSimpleName().toLowerCase();
			insert += nomeDaTabela + " (";
			insert += gerarStringDeCampos(classe, true);
			insert += ") values (" + gerarStringDeCampos(classe, false) + ")";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return insert;
	}
	
	private String gerarDeleteDe(Class<ENTIDADE> classe) {
		String delete = "delete from ";
		try {
			String nomeDaTabela = classe.getSimpleName().toLowerCase();
			delete += nomeDaTabela + " where ";
			String nomeDoId = Arrays.stream(classe.getFields())
				.filter(f -> f.isAnnotationPresent(ChavePrimaria.class))
				.findFirst().get().getName().toLowerCase();
			delete += nomeDoId + " = ?";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return delete;
	}
	
	private String gerarSelectDe(Class<ENTIDADE> classe) {
		String select = "select ";
		try {
			String nomeDaTabela = classe.getSimpleName().toLowerCase();
			select += " " + gerarStringDeCampos(classe, true);
			select += " from " + nomeDaTabela;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return select;
	}

	private String gerarStringDeCampos(Class<ENTIDADE> classe, boolean nomesDosCampos) {
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

	private List<Field> getAllFieldsRecursive(Class classe, List<Field> fields) {
		System.out.println(">>> " + classe.getSimpleName());
		if (!Entidade.class.isAssignableFrom(classe)) {
			return fields;
		}
		fields.addAll(Arrays.asList(classe.getDeclaredFields()));
		return getAllFieldsRecursive(classe.getSuperclass(), fields);
	}
	private Field[] getAllFields(Class<ENTIDADE> classe) {
		Field[] camposDaSuperclasse = classe.getSuperclass().getDeclaredFields();
		Field[] camposDaClasse =  classe.getDeclaredFields();
		List<Field> allFields = new ArrayList<>();
		allFields.addAll(Arrays.asList(camposDaSuperclasse));
		allFields.addAll(Arrays.asList(camposDaClasse));
		return allFields.toArray(new Field[] {});
	}

}
