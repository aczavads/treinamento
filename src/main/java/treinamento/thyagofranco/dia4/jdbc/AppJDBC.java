package treinamento.thyagofranco.dia4.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

public class AppJDBC {
	
	private static final Pessoa ana = new Pessoa( 1, "Ana Beatriz");
	private static final Pessoa laura = new Pessoa( 2, "Laura");
	private static final Pessoa rafaela = new Pessoa( 3, "Rafaela");

	public static void main(String[] args) {
		
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:h2:tcp://localhost/~/test","sa","");
			
			createTablePessoa(conn);
			
			conn.setAutoCommit(false); // tudo abaixo é uma transação
			
			//como se o BEGIN iniciasse aqui.
			
			insertPessoa(conn, ana);
			insertPessoa(conn,laura);
			insertPessoa(conn, rafaela);
			
			ana.setNome("Ana");
			updatePessoa(conn, ana);
			
			
			deletePessoa(conn, laura.getId());
			deletePessoa(conn, rafaela);
			
			//deletar rafaela
			//update Ana Beatriz para Ana
			
			JOptionPane.showMessageDialog(null, "Transação em curso");
			conn.commit();
			
			
			List<Pessoa> pessoas = recuperarTodas(conn);
			pessoas.forEach(pessoa -> System.out.println(pessoa));

			
			
			
		} catch (Exception erro) {
			throw new RuntimeException(erro);
		}
		System.out.println("Fim.");
		
		
		
	}
	
	private static List<Pessoa> recuperarTodas(Connection conn) throws SQLException {
		List<Pessoa> pessoas = new ArrayList<>();
		ResultSet rsPessoas = conn.createStatement()
				.executeQuery("select id, codigo, nome from pessoa");
		
		while (rsPessoas.next()) {
			UUID idRecuperado = (UUID)rsPessoas.getObject("id");
			String nomeRecuperado = rsPessoas.getString("nome");
			Integer codigoRecuperado = rsPessoas.getInt("codigo");
			Pessoa recuperada = new Pessoa(idRecuperado, codigoRecuperado, nomeRecuperado);
			pessoas.add(recuperada);
		}
		return pessoas;
	}



	private static void updatePessoa(Connection conn, Pessoa pessoa) throws SQLException {
		PreparedStatement psUpdate = conn.prepareStatement(
				"update pessoa set nome = ?, codigo = ? where id = ?");
		psUpdate.setString(1, pessoa.getNome());
		psUpdate.setInt(2, pessoa.getCodigo());
		psUpdate.setObject(3, pessoa.getId());
		psUpdate.executeUpdate();
		

	}
	
	private static void deletePessoa(Connection conn, UUID id) throws SQLException{
		PreparedStatement psDelete = conn.prepareStatement(
				"DELETE from pessoa WHERE id = ? ");
		psDelete.setObject(1, id);
		psDelete.executeUpdate();
		
	}
	
	private static void deletePessoa(Connection conn, Pessoa pessoa) throws SQLException{
		//PreparedStatement psDelete = conn.prepareStatement(
		//		"DELETE from pessoa WHERE id = ? ");
		//psDelete.setObject(1, pessoa.getId());
		//psDelete.executeUpdate();
		
		deletePessoa(conn, pessoa.getId());
	}

	//prepered statement evitar sql injection e executar ()
	private static void insertPessoa(Connection conn, Pessoa pessoa) throws SQLException {
		PreparedStatement psInsert = conn.prepareStatement(
				"insert into pessoa (id, codigo, nome) values(?,?,?)"); // não utiliza concatenação select ... + id, + codigo ...
		
		psInsert.setObject(1, pessoa.getId()); // inserindo no primeiro campo ? o ID da pessoa  (setObjetc pois jdbc não tem setUUID)
		psInsert.setInt(2, pessoa.getCodigo());
		psInsert.setString(3, pessoa.getNome());
		psInsert.executeUpdate(); // executeUpdate é para qualquer alteração no banco de dados.
		
		
	}

	
	//statement para executar uma vez só e não vou parametrizar query
	private static void createTablePessoa(Connection conn) throws SQLException {
		
		// create table Não utilizado em produção , pois são utilizadas migrations 
		conn.createStatement().execute(
				"create table if not exists pessoa ("
				+ "id uuid not null primary key,"
				+ "codigo integer not null unique,"
				+ "nome varchar(255) not null"
				+ ")");
		
		conn.createStatement().execute("delete from pessoa");
		
	}
}
