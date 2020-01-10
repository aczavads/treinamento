package valdenir.junior.dia5.associacoes;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import valdenir.junior.dia5.jpa.CPF;

public class App {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();

			em.createNativeQuery("delete from movimentoconta").executeUpdate();
			em.createQuery("delete from Conta").executeUpdate();
			em.createQuery("delete from Correntista").executeUpdate();
			em.getTransaction().commit();
			em.getTransaction().begin();

			gerenciarContas(em);

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.getTransaction().commit();
		}
		System.out.println("FIM");
	}

	private static void gerenciarContas(EntityManager em) throws Exception {
		Correntista correios = new CorrentistaJuridica(new CNPJ("20.727.219/0001-02"), "CORREIOS", LocalDate.now(),
				"CORREIOS");
		Correntista josias = new CorrentistaFisica(new CPF("399.311.000-52"), "Josias R.", LocalDate.now());
		Conta c1 = new Conta(2l, LocalDate.now(), josias);
		Conta c2 = new Conta(1l, LocalDate.now(), josias);
		Conta c3 = new Conta(3l, LocalDate.now(), correios);

		c1.debitar(LocalDate.of(2020, 3, 3), new BigDecimal(500), "hist.");

		c3.creditar(LocalDate.now(), new BigDecimal("50"), "historinha");
		c3.creditar(LocalDate.now(), new BigDecimal("30"), "historinha");
		c3.creditar(LocalDate.now(), new BigDecimal("100"), "historinha");
		c3.creditar(LocalDate.now(), new BigDecimal("140"), "historinha");
		c3.creditar(LocalDate.now(), new BigDecimal("139"), "historinha");

		em.persist(correios);
		em.persist(josias);
		em.persist(c2);
		em.persist(c1);
		em.persist(c3);

		em.getTransaction().commit();
		em.clear();
		em.getTransaction().begin();

		System.err.println("#########################################");
		System.err.println("#########################################");
		System.err.println("#########################################");
		System.err.println("#########################################");
		josias = em.find(Correntista.class, josias.getId());
		correios = em.find(Correntista.class, correios.getId());

		josias.getContas().forEach(c -> System.err.println(c));
		System.err.println("#########################################");
		correios.getContas().forEach(c -> System.err.println(c));
	}
}
