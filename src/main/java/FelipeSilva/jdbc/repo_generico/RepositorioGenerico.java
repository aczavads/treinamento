package FelipeSilva.jdbc.repo_generico;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class RepositorioGenerico<ENTIDADE extends Entidade> {
private Class<ENTIDADE> classeDaEntidade;

public RepositorioGenerico(Class<ENTIDADE> classeDaEntidade) {
	this.classeDaEntidade = classeDaEntidade;
	}
public void delete(UUID id) {
	
}
public List<ENTIDADE> selectAll(){
	return new ArrayList<ENTIDADE>();
}
private String gerarInserDe(Class<ENTIDADE> classe) {
	String insert = "insert into ";
	try {
		String nomeDaTabela = classe.getCanonicalName().toLowerCase();
			
	} catch (Exception e) {
		e.printStackTrace();
	}
	return insert;
}
public void insert(ENTIDADE objeto) {
	
}
private String gerarDeleteDe(Class<ENTIDADE> classe) {
	String delete = "delete from ";
	try {
		String nomeDaTabela = classe.getSimpleName().toLowerCase();
		delete += nomeDaTabela + " where ";
		String nomeDoId = Arrays.stream(classe.getDeclaredFields()).filter(f -> f.isAnnotationPresent(ChavePrimaria.class))
		.findFirst().get().getName().toLowerCase();
		delete += nomeDoId + " = ?";
	} catch (Exception e) {
		e.printStackTrace();
	}
	return delete;
	
}

private String gerarSelectDe(Class<? extends Entidade> classe) {
	String select = "select ";
	try {
		String nomeDaTabela = classe.getSimpleName().toLowerCase();
		Field[] campos = classe.getDeclaredFields();
		for (Field field : campos) {
			select += field.getName().toLowerCase() + ",";
		}
		select = select.substring(0, select.length() - 1);
		select += " From " + nomeDaTabela;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return select;
}

}
