package treinamento.diegomucheniski.dia5.jpa;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import diegomucheniski.domains.CPFValido;
import diegomucheniski.domains.Contrato;
import diegomucheniski.domains.InteiroPositivo;
import treinamento.diegomucheniski.dia5.jpa.repositories.ContratoRepository;

public class AppJPA {
	
	private static Contrato contrato1 = new Contrato(new InteiroPositivo(1), new CPFValido("211.211.682-72"), LocalDate.of(2020, 1, 10));
	private static Contrato contrato2 = new Contrato(new InteiroPositivo(2), new CPFValido("457.179.576-96"), LocalDate.of(2020, 1, 10));
	
	public static void main(String[] args) {	
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		try {
			
			factory = Persistence.createEntityManagerFactory("pu");
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.createNamedQuery("delete_contrato").executeUpdate();
			ContratoRepository contratoRepository = new ContratoRepository(manager);	
					
			contratoRepository.save(contrato1);
			contratoRepository.save(contrato2);
			
			contrato2.setNumero(new InteiroPositivo(22));
			contratoRepository.save(contrato2);
			
			// contratoRepository.delete(contrato2.getId());
			
			System.out.println();
			System.out.println("==========================================================");
			contratoRepository.findAll().forEach(System.out::println);
			System.out.println("==========================================================");
			System.out.println();
			
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
