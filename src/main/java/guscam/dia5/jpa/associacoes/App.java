package guscam.dia5.jpa.associacoes;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import guscam.dia5.jpa.Cpf;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;

		try {
			factory = Persistence.createEntityManagerFactory("pu");
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.createQuery("delete from Conta").executeUpdate();
			manager.createQuery("delete from Correntista").executeUpdate();
//			manager.createQuery("delete from MovimentoConta").executeUpdate();

			gerenciarContas(manager);
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			manager.getTransaction().commit();
		}

		System.out.println("Foi.");
	}

	private static void gerenciarContas(EntityManager manager) {
		Correntista josias = new CorrentistaFisica("Josias", new Cpf("07473951955"), LocalDate.of(1991, 1, 25));
		Conta c12 = new Conta(josias, 12L, LocalDate.of(2020, 1, 20));
		Conta c13 = new Conta(josias, 13L, LocalDate.of(2020, 1, 20));
		c12.creditar(LocalDate.now(), new BigDecimal("123.40"), "creditando");
		c13.debitar(LocalDate.now(), new BigDecimal("5454.40"), "debitando");

		Correntista empresa = new CorrentistaJuridica("Empresa", new Cnpj("19639972000159"), "Razao Social",
				LocalDate.of(1991, 1, 25));
		Conta c45 = new Conta(empresa, 45L, LocalDate.of(2020, 5, 12));

		manager.persist(josias);
		manager.persist(c12);
		manager.persist(c13);

		manager.persist(empresa);
		manager.persist(c45);

		manager.getTransaction().commit();
		manager.clear();
		manager.getTransaction().begin();

		josias = manager.find(CorrentistaFisica.class, josias.getId());
		empresa = manager.find(CorrentistaJuridica.class, empresa.getId());
		System.out.println("josias>>>" + josias.getContas());
		System.out.println("empresa>>>" + empresa.getContas());
	}

}
