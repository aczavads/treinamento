package GLF.dia3.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;

public class App {
	public static void main(String[] args) throws Exception {
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432", "postergres", "f�cil");
		
		//RegistradorDeTransa��es registrador = RegistradorFactory.createInstance("log");
		
		//Transa�ao  t = registrador.novaTransa��o(UUID.randomUUID());
		//t.registrar("Opera��o x");
		//t.finalizar;
		
	//	System.out.println(registrador.getQuantidadeDeTransacao());
	}
}


//factory � o getConnection