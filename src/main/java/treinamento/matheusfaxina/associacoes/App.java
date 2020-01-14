package treinamento.matheusfaxina.associacoes;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
		EntityManager manager = factory.createEntityManager();

		try {
			manager.getTransaction().begin();
			gerenciarrContas(manager);
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			manager.getTransaction().commit();
		}

		System.out.println("Foi.");
	}

	private static void gerenciarrContas(EntityManager manager) throws Exception {
		manager.createNamedQuery("delete_movimento_conta").executeUpdate();
		manager.createNamedQuery("delete_conta").executeUpdate();
		manager.createNamedQuery("delete_correntista").executeUpdate();
		manager.createNamedQuery("delete_correntista_juridico").executeUpdate();
		manager.createNamedQuery("delete_correntista_fisica").executeUpdate();
		correntistaJuridica(manager);
		correntistaFisica(manager);
	}
	
	private static void correntistaFisica(EntityManager manager) {
		CorrentistaFisica matheusFisico = new CorrentistaFisica(new CPF("10127483918"), "TESTE NOMEMEME", LocalDate.now(), "TESTE NOME");
		Conta conta1 = new Conta(4L, LocalDate.of(2020, 01, 01), matheusFisico);
		Conta conta2 = new Conta(5L, LocalDate.of(2020, 10, 02), matheusFisico);
		Conta conta3 = new Conta(6L, LocalDate.of(2020, 11, 03), matheusFisico);
		MovimentoConta creditar1 = conta1.creditar(LocalDate.of(2020, 01, 01), new BigDecimal("100"), "CREDITANDO O DINHEIRO NA CONTA DO " + conta1.getCorrentista().getNome() + "");
		MovimentoConta creditar2 = conta1.creditar(LocalDate.of(2020, 01, 01), new BigDecimal("200"), "CREDITANDO O DINHEIRO NA CONTA DO " + conta1.getCorrentista().getNome() + "");
		MovimentoConta creditar3 = conta1.creditar(LocalDate.of(2020, 01, 01), new BigDecimal("1100"), "CREDITANDO O DINHEIRO NA CONTA DO " + conta1.getCorrentista().getNome() + "");
		MovimentoConta creditar4 = conta1.creditar(LocalDate.of(2020, 01, 01), new BigDecimal("1200"), "CREDITANDO O DINHEIRO NA CONTA DO " + conta1.getCorrentista().getNome() + "");
		imprimirNoConsole(matheusFisico);

		//System.out.println(conta1.creditar(LocalDate.of(2020, 01, 01), new BigDecimal("200"), "CREDITANDO O DINHEIRO NA CONTA DO " + conta1.getCorrentista().getNome() + ""));
		
		manager.persist(matheusFisico);
		manager.persist(conta1);
		manager.persist(conta2);
		manager.persist(conta3);
//		manager.persist(creditar1);
//		manager.persist(creditar2);
//		manager.persist(creditar3);
//		manager.persist(creditar4);
		manager.getTransaction().commit();
		manager.clear();
		manager.getTransaction().begin();
		
		matheusFisico = manager.find(CorrentistaFisica.class, matheusFisico.getId());
		System.out.println(">>>>>>>>>>>>>>>> JURIDICO: " + matheusFisico.getContas().size());
	}

	private static void correntistaJuridica(EntityManager manager) {
		CorrentistaJuridica matheusJuridico = new CorrentistaJuridica(new CNPJ("85744649000170"), "TESTE RAZÃO SOCIAL", LocalDate.now(), "TESTE NOME");
		Conta conta1 = new Conta(1L, LocalDate.of(2020, 01, 01), matheusJuridico);
		Conta conta2 = new Conta(2L, LocalDate.of(2020, 10, 02), matheusJuridico);
		Conta conta3 = new Conta(3L, LocalDate.of(2020, 11, 03), matheusJuridico);
		imprimirNoConsole(matheusJuridico);

		manager.persist(matheusJuridico);
		manager.persist(conta1);
		manager.persist(conta2);
		manager.persist(conta3);
		manager.getTransaction().commit();
		manager.getTransaction().begin();
		
		matheusJuridico = manager.find(CorrentistaJuridica.class, matheusJuridico.getId());
		System.out.println(">>>>>>>>>>>>>>>> FISICO: " + matheusJuridico.getContas().size());
	}

	private static void imprimirNoConsole(Correntista matheus) {
		matheus.getContas().forEach(System.out::println);
	}

}
