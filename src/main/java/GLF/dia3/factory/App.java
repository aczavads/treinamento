package GLF.dia3.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;

public class App {
	public static void main(String[] args) throws Exception {
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432", "postergres", "fácil");
		
		//RegistradorDeTransações registrador = RegistradorFactory.createInstance("log");
		
		//Transaçao  t = registrador.novaTransação(UUID.randomUUID());
		//t.registrar("Operação x");
		//t.finalizar;
		
	//	System.out.println(registrador.getQuantidadeDeTransacao());
	}
}


//factory é o getConnection