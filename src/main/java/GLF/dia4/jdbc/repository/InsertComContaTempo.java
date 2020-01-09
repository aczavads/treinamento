package GLF.dia4.jdbc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

public class InsertComContaTempo {
	private static  final Pessoa ana = new Pessoa(1, "Ana Beatriz");
	private static final Pessoa laura = new Pessoa(2, "Laura");
	private static final Pessoa rafaela = new Pessoa(3, "Rafaela");
	
	private Connection conn;
	public InsertComContaTempo( Connection conn) {
		this.conn = conn;
		
	}
	
	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
			
			PessoaRepository repo = new PessoaRepository(conn);
			conn.setAutoCommit(false);
			repo.createTable();
			repo.insert(ana);
			repo.insert( laura);
			repo.insert(rafaela);
			JOptionPane.showMessageDialog(null, "Inserindo");
			conn.commit();
		
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		long inicio = System.currentTimeMillis();
		JOptionPane.showMessageDialog(null, "ESPERANDO...");
		System.out.println("Tempo total: " +(System.currentTimeMillis()-inicio));
		
	}
	
		
	public void insert(Pessoa pessoa) throws SQLException {
		PreparedStatement psInsert = conn.prepareStatement("insert into pessoa (id, codigo, nome) values (?,?,?)");
		psInsert.setObject(1, pessoa.getId());
		psInsert.setInt(2, pessoa.getCodigo());
		psInsert.setString(3, pessoa.getNome());
		psInsert.executeUpdate();
	}
}
