package treinamento.matheusfaxina.jdbc_generic;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.Arrays;

public class App {

	private static final Produto produto = new Produto("Produto 1");

	public static void main(String[] args) {
		Connection conn = null;
		RepositoyGeneric<Produto> repoProduto = new RepositoyGeneric<>(conn, Produto.class);

		repoProduto.insert(produto);
	}

	private static String gerarUpdateDe(Class<?> classe) {
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

	private static String gerarInsertDe(Class<?> classe) {
		String insert = "INSERT INTO ";
		try {
			String nomeDaTabela = classe.getSimpleName().toLowerCase();
			Field[] campos = classe.getDeclaredFields();
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

}
