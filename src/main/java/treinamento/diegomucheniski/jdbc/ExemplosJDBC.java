package treinamento.diegomucheniski.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.swing.JOptionPane;

import diegomucheniski.domains.Pessoa;

public class ExemplosJDBC {
	
	private static final Pessoa bruna = new Pessoa(1, "Bruna");
	private static final Pessoa diego = new Pessoa(2, "Diego");
	private static final Pessoa livia = new Pessoa(3, "Lívia");
	
	public static void main(String[] args) {
		try {			
			Connection conexao = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
			
			criarTabelaPessoa(conexao);
			conexao.setAutoCommit(false);
			
			inserirPessoa(conexao, bruna);
			inserirPessoa(conexao, diego);
			inserirPessoa(conexao, livia);
	
			// deletarPessoa(conexao, bruna);
			// deletarPessoa(conexao, livia.getId());
			
			diego.setNome("Diego Atualizado");
			atualizarPessoa(conexao, diego);
			
			JOptionPane.showMessageDialog(null, "Transação em curso...");
			conexao.commit();
			
			List<Pessoa> pessoas = recuperarPessoas(conexao);
			pessoas.forEach(pessoa -> System.out.println(pessoa));
			
		}
		catch(Exception erro) {
			throw new RuntimeException(erro);
		}
		System.out.println("Fim do processamento!");
	}

	private static List<Pessoa> recuperarPessoas(Connection conexao) throws SQLException {
		List<Pessoa> pessoas = new ArrayList<>();
		String sqlSelect = " SELECT ID, CODIGO, NOME FROM PESSOA ";
		ResultSet rsPessoas = conexao.createStatement().executeQuery(sqlSelect);
		
		while (rsPessoas.next()) {
			
			UUID idRetornado = (UUID)rsPessoas.getObject("id");
			Integer codigoRecuperado = rsPessoas.getInt("codigo");
			String nomeRetornado = rsPessoas.getString("nome");
			
			Pessoa pessoa = new Pessoa(idRetornado, codigoRecuperado, nomeRetornado);
			pessoas.add(pessoa);
		}		
		return pessoas;
	}

	private static void criarTabelaPessoa(Connection conexao) throws SQLException {
		
		String sqlCreate = " CREATE TABLE if not exists pessoa ("
						 + " id uuid not null primary key,"
						 + " codigo integer not null unique,"
						 + " nome varchar(255) not null"
					     + ")";
		
		conexao.createStatement().execute(sqlCreate);	
		conexao.createStatement().execute("DELETE FROM PESSOA");
	}

	private static void inserirPessoa(Connection conexao, Pessoa pessoa) throws SQLException {		
		String sqlInsert = "INSERT INTO PESSOA(id, codigo, nome) values (?, ?, ?)";		
		PreparedStatement psInsert = conexao.prepareStatement(sqlInsert);
		psInsert.setObject(1, pessoa.getId());
		psInsert.setInt(2, pessoa.getCodigo());
		psInsert.setString(3, pessoa.getNome());
		psInsert.executeUpdate();
	}
	
	private static void deletarPessoa(Connection conexao, Pessoa pessoa) throws SQLException {
		deletarPessoa(conexao, pessoa.getId());	
	}
	
	private static void deletarPessoa(Connection conexao, UUID idPessoa) throws SQLException {
		String sqlDelete = " DELETE FROM PESSOA WHERE id = ?";
		PreparedStatement psDelete = conexao.prepareStatement(sqlDelete);
		psDelete.setObject(1, idPessoa);
		psDelete.executeUpdate();		
	}
	
	private static void atualizarPessoa(Connection conexao, Pessoa pessoa) throws SQLException {
		String sqlUpdate = " UPDATE PESSOA SET NOME = ?, codigo = ? WHERE id = ?";
		PreparedStatement psUpdate = conexao.prepareStatement(sqlUpdate);
		psUpdate.setString(1, pessoa.getNome());
		psUpdate.setInt(2, pessoa.getCodigo());
		psUpdate.setObject(3, pessoa.getId());
		psUpdate.executeUpdate();			
	}
}
