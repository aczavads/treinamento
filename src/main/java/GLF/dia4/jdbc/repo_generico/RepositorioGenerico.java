package GLF.dia4.jdbc.repo_generico;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class RepositorioGenerico<ENTIDADE extends Entidade> {
	
	private Class<? extends Entidade> ClasseDaEntidade;
	
	public RepositorioGenerico(Class<? extends Entidade> classeDaEntidade) {
		this.ClasseDaEntidade = classeDaEntidade;
	}

	public void delete(UUID id) {
		
	}
	
	public void insert(ENTIDADE objeto) {
		
	}
	
	public List<ENTIDADE> selectAll(){
		return new ArrayList<ENTIDADE>();
		
	}
	
	private String gerarInsertDe(Class<ENTIDADE> classe) {
		String insert = "insert into";
		try {
			String nomeDaTabela = classe.getSimpleName().toLowerCase();
			insert += nomeDaTabela + "(";
			insert += gerarStringDeCampos(classe, true);
			insert += ")_ values (" + gerarStringDeCampos(classe, false) + ")";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return insert;
	}
	
	private  String gerarDeleteDe(Class<ENTIDADE> classe) {
		String delete = "delete from";
		
		try {
			String nomeDaTabela = classe.getSimpleName().toLowerCase();
			delete += nomeDaTabela + "where";
			String nomeDoId = Arrays.stream(classe.getDeclaredFields())
					.filter(f -> f.isAnnotationPresent(ChavePrimaria.class))
					.findFirst().get().getName().toLowerCase();
			delete += nomeDoId + " = ?";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return delete;
	}
	
	
	private  String gerarSelectDe(Class<ENTIDADE> classe ) {
		String select = "select";
		try {
			String nomeDaTabela = classe.getSimpleName().toLowerCase();
			select =" " + gerarStringDeCampos(classe, true);
			select += "from" +nomeDaTabela;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return select;
	}

	private String gerarStringDeCampos(Class<ENTIDADE> classe, boolean nomeDosCampos) {
		String stringDeCampos = "";
		Field [] campos = classe.getDeclaredFields();
		for (Field field : campos) {
			if(nomeDosCampos) {
				stringDeCampos +=field.getName().toLowerCase() + ",";
			} else {
				stringDeCampos += "?";
			}
			
		}
		stringDeCampos = stringDeCampos.substring(0, stringDeCampos.length()-1);
		return stringDeCampos;
	}
}
