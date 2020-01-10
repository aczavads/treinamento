package valdenir.junior.dia4.jdbc;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class RepositoryGenerico<ENTIDADE extends Entidade> {

	private Class<ENTIDADE> classeDaEntidade;

	public RepositoryGenerico(Class<ENTIDADE> classeDaEntidade) {
		this.classeDaEntidade = classeDaEntidade;
	}

	public void delete(UUID id) {

	}

	public void insert(ENTIDADE objeto) {
		System.out.println(gerarInsert());
	}

	public List<ENTIDADE> selectAll() {
		return null;
	}

	private String gerarInsert() {
		String insert = "insert into " + classeDaEntidade.getSimpleName().toLowerCase() + " ("
				+ gerarStringDeCampos(true) + ") values (" + gerarStringDeCampos(false) + ")";

		return insert;
	}

	private String gerarSelect() {
		String select = "select " + classeDaEntidade.getSimpleName().toLowerCase() + " ";
		select += gerarStringDeCampos(true);
		return select.substring(0, select.length() - 2) + " from " + classeDaEntidade.getSimpleName().toLowerCase();
	}

	private String gerarStringDeCampos(boolean nomeDosCampos) {
		String campos = "";
		for (Field field : getAllFields(classeDaEntidade, new ArrayList<Field>())) {
			campos += (nomeDosCampos ? field.getName().toLowerCase() : "?") + ", ";
		}
		return campos.substring(0, campos.length() - 2);
	}

	private List<Field> getAllFields(Class classe, List<Field> retorno) {
		retorno.addAll(Arrays.asList(classe.getDeclaredFields()));
		if (classe.equals(Entidade.class))
			return retorno;
		return getAllFields(classe.getSuperclass(), retorno);
	}

	private String gerarDelete() {
		String id = Arrays.asList(classeDaEntidade.getSuperclass().getDeclaredFields()).stream()
				.filter(f -> f.isAnnotationPresent(ChavePrimaria.class)).findFirst().get().getName();
		return "delete from " + classeDaEntidade.getSimpleName().toLowerCase() + " where " + id + " = ? ";
	}
}
