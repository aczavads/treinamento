package thais.matera.dia5.associacoes;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import treinamento.dia5.jpa.CPF;

public class App {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
		EntityManager manager = factory.createEntityManager();
		
		try {
			manager.getTransaction().begin();
			
			manager.createQuery("delete from Conta").executeUpdate();
			manager.createQuery("delete from Correntista").executeUpdate();
			
			gerenciarContas(manager);
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			manager.getTransaction().commit();
		}
		
		System.out.println("Foi.");
	}

	private static void gerenciarContas(EntityManager em) throws Exception {
		CorrentistaFisica josias = new CorrentistaFisica("Josias Alberto", new CPF("387.389.969.87"), LocalDate.of(2020, 1, 10));
		CorrentistaJuridica matera = new CorrentistaJuridica("Matera", new CNPJ("15.280.508/0001-68"), "MATERA SYSTEMS", LocalDate.of(2020, 1, 10));
		
		Conta c12 = new Conta(josias, 12L, LocalDate.of(2020, 1, 10));
		Conta c13 = new Conta(matera, 14L, LocalDate.of(2020, 1, 10));
		Conta c14 = new Conta(josias, 15L, LocalDate.of(2020, 1, 10));
		Conta c15 = new Conta(matera, 16L, LocalDate.of(2020, 1, 10));
		
		em.persist(c12);
		em.persist(josias);
		em.persist(c13);
		em.persist(matera);
		em.persist(c14);
		em.persist(c15);
		
		em.getTransaction().commit();
		em.clear();
		em.getTransaction().begin();		

		Conta bufferConta = em.find(Conta.class, c13.getId());
		System.out.println(bufferConta.getCorrentista().getNome());
		
		Correntista buffer= em.find(Correntista.class, josias.getId());
		System.out.println(buffer.getContas().size());
		
		Correntista buffer2= em.find(Correntista.class, matera.getId());
		System.out.println(buffer2.getContas().size());
	}
}
