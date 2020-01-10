package treinamento.diegomucheniski.dia5.jpa.associacoes;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import treinamento.diegomucheniski.domains.Conta;
import treinamento.diegomucheniski.domains.Correntista;

public class AppAssociacoes {
	
	public static void main(String[] args) {
			
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
			EntityManager manager = factory.createEntityManager();
			
			try {
				manager.getTransaction().begin();
				manager.createQuery("delete from Conta").executeUpdate();
				manager.createQuery("delete from Correntista").executeUpdate();
				gerenciarContas(manager);
			} 
			catch (Exception e) {
				manager.getTransaction().rollback();
				e.printStackTrace();
			}
			finally {
				manager.getTransaction().commit();
				System.out.println("Processo finalizado");
			}
			
		}
	
	private static void gerenciarContas(EntityManager manager) throws Exception {
		
		Correntista joao = new Correntista("João Mucheniski");
		Conta contaBancoDoBrasio = new Conta(12L, LocalDate.of(2020, 1, 10), joao);
		
		imprimirContasNoConsole(joao);
		
		manager.persist(joao);
		manager.persist(contaBancoDoBrasio);
		
		manager.getTransaction().commit();
		manager.getTransaction().begin();
		
	}

	private static void imprimirContasNoConsole(Correntista joao) {
		System.out.println();
		System.out.println("IMPRESSÃO DAS CONTAS=========================================");
		joao.getContas().forEach(System.out::println);
	}


}
