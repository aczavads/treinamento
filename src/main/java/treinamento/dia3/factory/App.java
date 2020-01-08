package treinamento.dia3.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.UUID;

public class App {
	
	public static void main(String[] args) throws Exception {
//		Connection conn = DriverManager.getConnection(
//				"jdbc:postgresql://localhost:5432","postgres","fácil");
		
		RegistradorDeTransacoes registrador = RegistradorFactory.createInstance();
		System.out.println(registrador.getClass().getName());
		
		Transacao t = registrador.novaTransação(UUID.randomUUID());
		t.registrar("Operação x");
		t.registrar("Operação y");
		t.finalizar();
		
		System.out.println(registrador.getQuantidadeDeTransacoes());
	}

}
