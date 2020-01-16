package treinamento.diegomucheniski.dia5.jpa;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import diegomucheniski.domains.CPFValido;
import diegomucheniski.domains.Contrato;
import diegomucheniski.domains.InteiroPositivo;

public class ExemploJPA {
	
	private static Contrato contrato1;
	private static Contrato contrato2;
	
	static {
		try {
			contrato1 = new Contrato(new InteiroPositivo(1), new CPFValido("211.211.682-72"), LocalDate.of(2020, 1, 10));
			contrato2 = new Contrato(new InteiroPositivo(2), new CPFValido("457.179.576-96"), LocalDate.of(2020, 1, 10));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
		EntityManager manager = factory.createEntityManager();
		
		try {
			manager.getTransaction().begin();
			
			// manager.createQuery("delete from Contrato").executeUpdate(); // Cria uma query JPA			
			// manager.createNativeQuery("delete from contrato").executeUpdate(); // Cria uma query nativa, o contrato não mais a classe e sim a do banco mesmo
			manager.createNamedQuery("delete_contrato").executeUpdate();
			manager.persist(contrato1);
			manager.persist(contrato2);
			manager.remove(contrato2);
		} 
		catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		}
		finally {
			manager.getTransaction().commit();
		}
		
	}

}
