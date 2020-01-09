package treinamento.thyagofranco.dia4.jdbc.repository_generico;


import java.lang.reflect.Field;
import java.util.Arrays;

public class App {
	public static void main(String[] args) {
		String select = gerarSelectDe(Produto.class);
		String delete = gerarDeleteDe(Produto.class);
		System.out.println(select);
		System.out.println(delete);
		
	}
	
	
	private static String gerarDeleteDe(Class<? extends Entidade> classe) {
		String delete = "delete from";
		try {
			String nomeDaTabela = classe.getSimpleName().toLowerCase();
			delete += nomeDaTabela + " where ";
			String nomeDoId = Arrays.stream(classe.getDeclaredFields())
				.filter(f -> f.isAnnotationPresent(ChavePrimaria.class))
				.findFirst().get().getName().toLowerCase();
			delete += nomeDoId + " = ?";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return delete;
	}
	
	private static String gerarSelectDe(Class<? extends Entidade> classe) {   //<? extends > Isso é generics
		String select = "";
		try {
			String nomeDaTabela = classe.getSimpleName().toLowerCase();
			Field[] campos = classe.getDeclaredFields();
			for (Field field : campos) {
				select += field.getName().toLowerCase() + ",";
				
			}
			select = select.substring(0,select.length()-1);   // tirando a virgula depois do último campo
			select += "from " + nomeDaTabela;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return select;
	}
}
