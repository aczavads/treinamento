package treinamento.guilhermeperes.dia5.jpa;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
		EntityManager manager = factory.createEntityManager();
		
		ContratoRepository repo = new ContratoRepository(manager);
		
		Contrato contrato1 = new Contrato(1, LocalDate.of(2020, 1, 10));
		Contrato contrato2 = new Contrato(2, LocalDate.of(2020, 1, 11));
		Contrato contrato3 = new Contrato(3, LocalDate.of(2020, 1, 12));
		
		try {
			manager.getTransaction().begin();
			
			repo.save(contrato1);
			repo.save(contrato2);
			repo.save(contrato3);
			
			System.out.println(repo.findById(contrato1.getId()).toString());
			
			repo.delete(contrato3);
			repo.deleteById(contrato1.getId());
			
			repo.findAll().forEach(System.out::println);
			
			contrato2.setNumero(20);
			repo.save(contrato2);
			
			repo.findAll().forEach(System.out::println);
			
			repo.deleteAll();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			manager.getTransaction().commit();
		}
	}
}
