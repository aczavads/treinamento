package treinamento.dia3.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.UUID;

public class App {
	
	public static void main(String[] args) throws Exception {
//		Connection conn = DriverManager.getConnection(
//				"jdbc:postgresql://localhost:5432","postgres","f�cil");
		
		RegistradorDeTransacoes registrador = RegistradorFactory.createInstance();
		System.out.println(registrador.getClass().getName());
		
		Transacao t = registrador.novaTransa��o(UUID.randomUUID());
		t.registrar("Opera��o x");
		t.registrar("Opera��o y");
		t.finalizar();
		
		System.out.println(registrador.getQuantidadeDeTransacoes());
	}

}
