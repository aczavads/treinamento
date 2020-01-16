package treinamento.diegomucheniski.dia4.programa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import javax.swing.JOptionPane;

import diegomucheniski.domains.Pessoa;
import treinamento.diegomucheniski.dia4.repositories.PessoaRepository;

public class PessoaAppJDBC {
	
	

	public static void main(String[] args) {
		
		final Pessoa bruna = new Pessoa(1, "Bruna");
		final Pessoa diego = new Pessoa(2, "Diego");
		final Pessoa livia = new Pessoa(3, "Lívia");
		
		try {			
			Connection conexao = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
			PessoaRepository pessoaRepository = new PessoaRepository(conexao);
			
			pessoaRepository.createTable();
			conexao.setAutoCommit(false);
			
			pessoaRepository.insert(bruna);
			pessoaRepository.insert(diego);
			pessoaRepository.insert(livia);	
		
			pessoaRepository.delete(bruna);
			pessoaRepository.delete(livia.getId());
			
			diego.setNome("Diego Atualizado");
			pessoaRepository.update(diego);			
			
			JOptionPane.showMessageDialog(null, "Transação em curso...");
			conexao.commit();
			
			List<Pessoa> pessoas = pessoaRepository.findAll();
			pessoas.forEach(pessoa -> System.out.println(pessoa));
			
		}
		catch(Exception erro) {
			throw new RuntimeException(erro);
		}
		System.out.println("Fim do processamento!");
		
	}

}
