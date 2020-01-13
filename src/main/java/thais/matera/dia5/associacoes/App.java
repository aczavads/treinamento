package thais.matera.dia5.associacoes;

import java.math.BigDecimal;
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
			
			manager.createQuery("delete from MyConta").executeUpdate();
			manager.createQuery("delete from MyCorrentista").executeUpdate();
			manager.createQuery("delete from MovimentoConta").executeUpdate();
			
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
		MyCorrentistaFisica josias = new MyCorrentistaFisica("Josias Alberto", new CPF("387.389.969.87"), LocalDate.of(2020, 1, 10));
		MyCorrentistaJuridica matera = new MyCorrentistaJuridica("Matera", new CNPJ("15.280.508/0001-68"), "MATERA SYSTEMS", LocalDate.of(2020, 1, 10));
		
		MyConta c12 = new MyConta(josias, 12L, LocalDate.of(2020, 1, 10));
//		MyConta c13 = new MyConta(matera, 14L, LocalDate.of(2020, 1, 10));
//		MyConta c14 = new MyConta(josias, 15L, LocalDate.of(2020, 1, 10));
//		MyConta c15 = new MyConta(matera, 16L, LocalDate.of(2020, 1, 10));
		
//		c12.debitar(LocalDate.of(2020, 1, 12), new BigDecimal("1000.00"), "adiantamento");
//		c12.debitar(LocalDate.of(2020, 1, 12), new BigDecimal("1000.00"), "adiantamento");
		c12.debitar(LocalDate.of(2020, 1, 12), new BigDecimal("1000.00"), "adiantamento");
		
		em.persist(josias);
		em.persist(c12);
//		em.persist(c13);
//		em.persist(matera);
//		em.persist(c14);
//		em.persist(c15);
//		
//		em.getTransaction().commit();
//		em.clear();
//		em.getTransaction().begin();		
//
//		MyConta bufferConta = em.find(MyConta.class, c13.getId());
//		System.out.println(bufferConta.getCorrentista().getNome());
//		
//		MyCorrentista buffer= em.find(MyCorrentista.class, josias.getId());
//		System.out.println(buffer.getContas().size());
//		
//		MyCorrentista buffer2= em.find(MyCorrentista.class, matera.getId());
//		System.out.println(buffer2.getContas().size());
	}
}
