package treinamento.dia5.jpa.associacoes;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

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
//		manager.clear();
//		manager.getTransaction().begin();		
//		manager.createQuery("select c from Correntista c", Correntista.class).getResultList().forEach(App::imprimirContasNoConsole);
		System.out.println("Foi.");
	}
	private static void gerenciarContas(EntityManager em) throws Exception {
		Correntista josias = new CorrentistaFisica("Josias Alberto", new CPF("016.769.639-44"),LocalDate.of(2000, 10, 10));
		Conta c12 = new Conta(josias, 12L, LocalDate.of(2020, 1, 10));		
		Conta c15 = new Conta(josias, 15L, LocalDate.of(2020, 1, 10));		
		Conta c99 = new Conta(josias, 99L, LocalDate.of(2020, 1, 10));		
		c12.debitar(LocalDate.of(2020, 1, 9), new BigDecimal("100.00"), "Lançamento inicial");
		c12.creditar(LocalDate.of(2020, 1, 10), new BigDecimal("7500.00"), "Adiantamento de salário");

		Correntista matera = new CorrentistaJuridica("Matera", "MATERA SYSTEMS", LocalDate.of(2000, 10, 10));
		Conta c199 = new Conta(matera, 199L, LocalDate.of(2020, 1, 10));		
		Conta c177 = new Conta(matera, 177L, LocalDate.of(2020, 1, 10));		
		c177.creditar(LocalDate.of(2019, 12, 9), new BigDecimal("66567.00"), "Lançamento inicial");
		c177.creditar(LocalDate.of(2019, 12, 10), new BigDecimal("1000.00"), "Créditos recebidos");
		c177.creditar(LocalDate.of(2019, 12, 10), new BigDecimal("1000.00"), "Créditos recebidos");
		
		em.persist(josias);
		em.persist(c12);
		em.persist(c15);
		em.persist(c99);

		em.persist(matera);
		em.persist(c199);
		em.persist(c177);

		em.getTransaction().commit();
		em.clear(); //gambiarra!!!! Testar no postgres.
		em.getTransaction().begin();
		imprimirContasNoConsole(em.find(CorrentistaFisica.class, josias.getId()));
		imprimirContasNoConsole(em.find(CorrentistaJuridica.class, matera.getId()));
	}
	private static void imprimirContasNoConsole(Correntista correntista) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		correntista.getContas().forEach(System.out::println);
	}
}
