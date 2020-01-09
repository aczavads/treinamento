package GLF.dia4.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.swing.JOptionPane;

import GLF.dia4.jdbc.repository.PessoaRepository;

import GLF.dia4.jdbc.repository.Pessoa;

public class AppJDBC {
	private static  final Pessoa ana = new Pessoa(1, "Ana Beatriz");
	private static final Pessoa laura = new Pessoa(2, "Laura");
	private static final Pessoa rafaela = new Pessoa(3, "Rafaela");
	
	public static void main (String[] args ) {
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
			
			PessoaRepository repo = new PessoaRepository(conn);
			
			repo.createTable();
			conn.setAutoCommit(false);
			
			long  inicio = System.currentTimeMillis(); 
			for(int i = 0; i < 1000; i++ ) {
				repo.insertComCashDePreparo(new Pessoa(i, "nome"));
			}
			conn.commit();
			System.out.println("Preparando uma vez so: " +(System.currentTimeMillis()-inicio));
			
			repo.createTable();
			conn.setAutoCommit(false);
			
			inicio = System.currentTimeMillis(); 
			for(int i = 0; i < 1000; i++ ) {
				repo.insert(new Pessoa(i, "nome"));
			}
			conn.commit();
			System.out.println("Preparando cada insert: " +(System.currentTimeMillis()-inicio));
			
			/*repo.insert(ana);
			repo.insert( laura);
			repo.insert(rafaela);
			
			JOptionPane.showMessageDialog(null, "Transação em curso...");
			conn.commit();
			
			
			ana.setNome("Ana");
			repo.update( ana);
			
			repo.delete( rafaela);
			
			
			conn.commit();
			
			List<Pessoa> pessoas = repo.selectAll();
			pessoas.forEach(p -> System.out.println(p));*/
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		System.out.println("Fim!");
	}
	
	
}
