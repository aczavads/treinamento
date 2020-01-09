package giovani.bueno.jdbc;



import java.sql.Connection;
import java.sql.DriverManager;

import java.util.UUID;

import giovani.bueno.jdbc.repository.PessoaRepository;


public class AppJDBC {
	
	public static final Pessoa giovani = new Pessoa(1,"Giovani");
	public static final Pessoa laura =   new Pessoa(2,"Laura");
	public static final Pessoa rafael =  new Pessoa(3,"Rafaela");
	
	public static void main(String[] args) {
		try {
			
			Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		   PessoaRepository pessoaRepository = new PessoaRepository(conn);
		   conn.setAutoCommit(false);

//			pessoaRepository.createTable();
//			JOptionPane.showMessageDialog(null, "Transação em andamento..");
//			pessoaRepository.insert(giovani);
//			pessoaRepository.insert(laura);
//			pessoaRepository.insert(rafael);
//			
//			giovani.setNome("Giovani Bueno");
//			pessoaRepository.update(giovani);
//			
//			pessoaRepository.delete(rafael);
//			
//			List<Pessoa> pessoas =   pessoaRepository.selectAll();
//			pessoas.forEach(p -> System.out.println(p));
			
			long inicio  = System.currentTimeMillis();
			
			for (int i = 0; i < 1000; i++) {
				UUID uuid = UUID.randomUUID();
				String myRandom = uuid.toString();
				System.out.println(myRandom.substring(0,20));
			    Pessoa p = new Pessoa(UUID.randomUUID(),i+4,myRandom);
			    pessoaRepository.insert(p);
			}
			conn.commit();
			System.out.println("Tempo total: " +(System.currentTimeMillis()-inicio));
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		System.out.println("FIM");
	}
	
	
	public static void testeDePreparedStatement() {
		
	}

//	private static List<Pessoa> recuperarTodas(Connection conn) throws SQLException {
//		List<Pessoa> listPessoas = new ArrayList<>();
//		ResultSet rsPessoas = conn.createStatement().executeQuery("select id, codigo,nome from pessoa");
//		while(rsPessoas.next()) {
//			Pessoa pessoaRecuperada = new Pessoa(		
//		        (UUID) rsPessoas.getObject("id"),
//		        rsPessoas.getInt("codigo"),
//		        rsPessoas.getString("nome"));
//		  listPessoas.add(pessoaRecuperada);
//		}
//		return listPessoas;
//		
//	}
//
//	private static void insertPessoa(Connection conn,Pessoa pessoa) throws SQLException {
//		PreparedStatement psInsert = conn.prepareStatement(
//				"insert into pessoa(id,codigo,nome) values(?,?,?)"); 
//		
//		psInsert.setObject(1, pessoa.getId());
//		psInsert.setInt(2, pessoa.getCodigo());
//		psInsert.setString(3,pessoa.getNome());
//		psInsert.executeUpdate();
//	}
//
//	private static void updatePessoa(Connection conn, Pessoa pessoa) throws SQLException {
//		PreparedStatement psUpdate = conn.prepareStatement(
//				"update pessoa set nome=?, codigo = ? where id=?");
//		psUpdate.setString(1,pessoa.getNome());
//		psUpdate.setInt(2, pessoa.getCodigo());
//		psUpdate.setObject(3, pessoa.getId());
//		
//		psUpdate.executeUpdate();
//	}
//	
//	private static void deletePessoa(Connection conn, UUID id) throws SQLException {
//		PreparedStatement psDelete = conn.prepareStatement("Delete from pessoa where id = ?");
//		psDelete.setObject(1,id);
//		psDelete.executeUpdate();	
//	}
//
//	private static void deletePessoa(Connection conn, Pessoa pessoa) throws SQLException {
//	  deletePessoa(conn, pessoa.getId());
//	}
//	
//
//	private static void createTablePessoa(Connection conn) throws SQLException {
//      conn.createStatement().execute(
//    		  "create table if not exists pessoa ("
//    		  + "id uuid not null primary key,"
//    		  + "codigo integer not null unique,"
//    		  + "nome varchar(255) not null"
//    		  + ")");
//      conn.createStatement().execute("delete from pessoa");
//	}

}
