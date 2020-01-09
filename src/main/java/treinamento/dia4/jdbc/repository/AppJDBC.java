package treinamento.dia4.jdbc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import javax.swing.JOptionPane;


public class AppJDBC {
	private static final Pessoa ana = new Pessoa(1, "Ana Beatriz");
    private static final Pessoa laura = new Pessoa(2, "Laura");
	private static final Pessoa rafaela = new Pessoa(3, "Rafaela");

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:h2:tcp://localhost/~/test","sa","");			
			PessoaRepository repo = new PessoaRepository(conn);
		
			repo.createTable();
			conn.setAutoCommit(false);
			
			long inicio = System.currentTimeMillis();
			for (int i = 0; i < 10000; i++) {
				repo.insertComCacheDoPreparedStatement(new Pessoa(i, "nome"));				
				//repo.insert(new Pessoa(i, "nome"));				
			}
			conn.commit();
			//System.out.println("Preparando a cada insert: " + (System.currentTimeMillis()-inicio));
			System.out.println("Preparando uma vez só: " + (System.currentTimeMillis()-inicio));

			repo.createTable();
			conn.commit();

			inicio = System.currentTimeMillis();
			for (int i = 0; i < 10000; i++) {
				repo.insert(new Pessoa(i, "nome"));				
				//repo.insertComCacheDoPreparedStatement(new Pessoa(i, "nome"));				
			}
			conn.commit();
			System.out.println("Preparando a cada insert: " + (System.currentTimeMillis()-inicio));
			//System.out.println("Preparando uma vez só: " + (System.currentTimeMillis()-inicio));
			
			/*
			repo.insert(ana);
			repo.insert(laura);
			repo.insert(rafaela);
			
			JOptionPane.showMessageDialog(null, "Transação em curso...");
			conn.commit();
			
			ana.setNome("Ana");
			repo.update(ana);
			repo.delete(rafaela.getId());
			repo.delete(rafaela);
			conn.commit();
			
			List<Pessoa> pessoas = repo.selectAll();
			pessoas.forEach(p -> System.out.println(p));
			*/
			
		} catch (Exception erro) {
			throw new RuntimeException(erro);
		}
		System.out.println("Fim.");
	}
}
