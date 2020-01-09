package giovani.bueno.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.swing.JOptionPane;


public class AppJDBC {
	
	public static final Pessoa giovani = new Pessoa(1,"Giovani");
	public static final Pessoa laura =   new Pessoa(2,"Laura");
	public static final Pessoa rafael =  new Pessoa(3,"Rafaela");
	
	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
			createTablePessoa(conn);
			conn.setAutoCommit(false);
			
			insertPessoa(conn, giovani);
			insertPessoa(conn, laura);
			insertPessoa(conn, rafael);
			JOptionPane.showMessageDialog(null, "Transação em andamento..");			
			
			giovani.setNome("Giovani Bueno");
			updatePessoa(conn,giovani);
			
			deletePessoa(conn, rafael);
			conn.commit();
			
			List<Pessoa> pessoas =   recuperarTodas(conn);
			pessoas.forEach(p -> System.out.println(p));
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		System.out.println("FIM");
	}

	private static List<Pessoa> recuperarTodas(Connection conn) throws SQLException {
		List<Pessoa> listPessoas = new ArrayList<>();
		ResultSet rsPessoas = conn.createStatement().executeQuery("select id, codigo,nome from pessoa");
		while(rsPessoas.next()) {
			Pessoa pessoaRecuperada = new Pessoa(		
		        (UUID) rsPessoas.getObject("id"),
		        rsPessoas.getInt("codigo"),
		        rsPessoas.getString("nome"));
		  listPessoas.add(pessoaRecuperada);
		}
		return listPessoas;
		
	}

	private static void insertPessoa(Connection conn,Pessoa pessoa) throws SQLException {
		PreparedStatement psInsert = conn.prepareStatement(
				"insert into pessoa(id,codigo,nome) values(?,?,?)"); 
		
		psInsert.setObject(1, pessoa.getId());
		psInsert.setInt(2, pessoa.getCodigo());
		psInsert.setString(3,pessoa.getNome());
		psInsert.executeUpdate();
	}

	private static void updatePessoa(Connection conn, Pessoa pessoa) throws SQLException {
		PreparedStatement psUpdate = conn.prepareStatement(
				"update pessoa set nome=?, codigo = ? where id=?");
		psUpdate.setString(1,pessoa.getNome());
		psUpdate.setInt(2, pessoa.getCodigo());
		psUpdate.setObject(3, pessoa.getId());
		
		psUpdate.executeUpdate();
	}
	
	private static void deletePessoa(Connection conn, UUID id) throws SQLException {
		PreparedStatement psDelete = conn.prepareStatement("Delete from pessoa where id = ?");
		psDelete.setObject(1,id);
		psDelete.executeUpdate();	
	}

	private static void deletePessoa(Connection conn, Pessoa pessoa) throws SQLException {
	  deletePessoa(conn, pessoa.getId());
	}
	

	private static void createTablePessoa(Connection conn) throws SQLException {
      conn.createStatement().execute(
    		  "create table if not exists pessoa ("
    		  + "id uuid not null primary key,"
    		  + "codigo integer not null unique,"
    		  + "nome varchar(255) not null"
    		  + ")");
      conn.createStatement().execute("delete from pessoa");
	}

}
