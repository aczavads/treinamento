package FelipeSilva.dia5.jpa;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import treinamento.dia5.jpa.Contrato;

public class App {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
		EntityManager manager = factory.createEntityManager();
		try {
			manager.getTransaction().begin();			
			gerenciarContas(manager);
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			manager.getTransaction().commit();
		}
	}

private static void gerenciarContas(EntiityManager em) throws Exception{
	Correntista josias = new Correntista("Josias Alberto");
	Conta c12 = new Conta(josias, 12L, LocalDate.of(2020, 1, 10));
}
}
