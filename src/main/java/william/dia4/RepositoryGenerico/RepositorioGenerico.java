package william.dia4.RepositoryGenerico;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class RepositorioGenerico<ENTIDADE extends Entidade> {
	private Class<? extends Entidade> classe;
	private Connection conn;
	
	
	
	public RepositorioGenerico(Connection conn, Class<? extends Entidade> classeDaEntidade) {
		super();
		this.conn = conn;
		this.classe = classeDaEntidade;
	}

	public void delete(UUID id) {
		
	}
	
	public List<ENTIDADE> selectAll(){
		return null;
		
	}
	
	
	

	public String gerarDeleteDe() {
		String delete = "delete from ";
		try {
			String nomeDaTabela = classe.getSimpleName().toLowerCase();
			delete += nomeDaTabela + " where ";
			String nomeDoId = Arrays.stream(classe.getSuperclass().getDeclaredFields())
					.filter(f -> f.isAnnotationPresent(ChavePrimaria.class))
					.findFirst().get().getName().toLowerCase();
			delete += nomeDoId + " = ?";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return delete;
		
	}

	public String gerarSelectDe() {
		String select = "select ";
		try {
			String nomeDaTabela = classe.getSimpleName().toLowerCase();
			Field[] campos = classe.getDeclaredFields();
			for (Field field : campos) {
				select += field.getName().toLowerCase() + ", ";
			}
			select = select.substring(0, select.length() - 1);
			select += " from " + nomeDaTabela;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return select;
	}
}
