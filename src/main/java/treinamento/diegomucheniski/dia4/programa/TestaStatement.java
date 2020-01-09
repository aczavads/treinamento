package treinamento.diegomucheniski.dia4.programa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import treinamento.diegomucheniski.dia4.repositories.PessoaRepository;
import treinamento.diegomucheniski.domains.Pessoa;

public class TestaStatement {

	public static void main(String[] args) {
		
		try {			
			Connection conexao = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
			PessoaRepository pessoaRepository = new PessoaRepository(conexao);	
			
			String sqlInsert = "INSERT INTO PESSOA(id, codigo, nome) values (?, ?, ?)";
			PreparedStatement psInsert = conexao.prepareStatement(sqlInsert);
	
			conexao.setAutoCommit(false);
			
			pessoaRepository.createTable();
			conexao.commit();			
			// Teste com statement dentro do insert			
			Long inicio = System.currentTimeMillis();
			for (int i = 0; i <= 1000; i++) {
				pessoaRepository.insert(new Pessoa(i, "Bruna"));				
			}			
			conexao.commit();
			System.out.println("Tempo total statement dentro do método: " + (System.currentTimeMillis() - inicio));
			
			pessoaRepository.createTable();
			conexao.commit();			
			// Teste com statement fora do insert			
			inicio = System.currentTimeMillis();
			for (int i = 0; i < 1000; i++) {				
				pessoaRepository.insert(new Pessoa(i, "Diego"), psInsert);				
			}			
			conexao.commit();
			System.out.println("Tempo total statement como parâmetro: " + (System.currentTimeMillis() - inicio));						
					
			
		}
		catch(Exception erro) {
			throw new RuntimeException(erro);
		}
		System.out.println("Fim do processamento!");
		
	}

}
