package treinamento.dia5.jpa.repository;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import treinamento.dia5.jpa.CPF;
import treinamento.dia5.jpa.Contrato;
import treinamento.dia5.jpa.InteiroPositivo;

public class AppJpaRepository {
	private static Contrato contrato1;
	private static Contrato contrato2;
	
	static {
		try {
			contrato1 = new Contrato(
					new InteiroPositivo(1), LocalDate.of(2020, 1, 10),
					new CPF("242.798.315-21"));
			
			contrato2 = new Contrato(
					new InteiroPositivo(2), LocalDate.of(2020, 1, 10),
					new CPF("515.107.071-15"));			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		try {
			factory = Persistence.createEntityManagerFactory("pu");
			manager = factory.createEntityManager();
			manager.getTransaction().begin();		
			manager.createQuery("delete from Contrato").executeUpdate(); //limpar o banco! :D
			ContratoRepository repo = new ContratoRepository(manager);
			repo.save(contrato1);
			repo.save(contrato2);
			contrato2.setNumero(new InteiroPositivo(22));
			repo.save(contrato2);					
			//repo.delete(contrato1.getId());
			repo.delete(contrato1);
			//repo.findAll().forEach(System.out::println);
			for (Contrato c : repo.findAll()) {
				System.out.println(c);
			}
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			manager.getTransaction().commit();
		}
		
		System.out.println("Foi.");
	}

}
