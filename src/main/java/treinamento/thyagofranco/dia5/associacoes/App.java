package treinamento.thyagofranco.dia5.associacoes;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import treinamento.thyagofranco.dia5.CPF;

public class App {
	private static EntityManagerFactory factory = null;
	private static EntityManager manager = null;

	static {
		try {
			factory = Persistence.createEntityManagerFactory("pu");
			manager = factory.createEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		try {

			manager.getTransaction().begin();
			manager.createQuery("delete from Conta").executeUpdate();
			manager.createQuery("delete from Correntista").executeUpdate();
			manager.createQuery("delete from CorrentistaPessoaFisica").executeUpdate();
			manager.createQuery("delete from CorrentistaPessoaJuridica").executeUpdate();

			gerenciarContaPessoaFisica(manager);
			gerenciarContaPessoaJuridica(manager);

		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();

		} finally {
			manager.getTransaction().commit();
		}

		System.out.println("Foi.");
	}

	private static void gerenciarContaPessoaJuridica(EntityManager em) {
		Correntista matera = new CorrentistaPessoaJuridica(new CNPJ("66.755.978/0001-71"), "MTPR",
				LocalDate.of(1987, 1, 1), "Matera");

		Conta contaMatera = new Conta(matera, 11L, LocalDate.of(2020, 1, 10));

		imprimirContasNoConsole(matera);

		persistirNoBanco(em, matera, contaMatera);

		contaMatera = em.find(Conta.class, contaMatera.getId());
		System.out.println(contaMatera);

		matera = em.find(CorrentistaPessoaJuridica.class, matera.getId());
		System.out.println(matera.getContas());

	}

	private static void gerenciarContaPessoaFisica(EntityManager em) throws Exception {

		Correntista josias = new CorrentistaPessoaFisica(new CPF("054.888.485-41"),
				LocalDate.of(2020, 01, 10), "Josias");
		Conta c12 = new Conta(josias, 12L, LocalDate.of(2020, 1, 10));

		imprimirContasNoConsole(josias);

		persistirNoBanco(em, josias, c12);

		c12 = em.find(Conta.class, c12.getId());
		System.out.println(c12);

		josias = em.find(CorrentistaPessoaFisica.class, josias.getId());
		System.out.println(josias.getContas());
		
		MovimentoConta credito1 = new MovimentoConta(LocalDate.of(2020, 1, 10), new BigDecimal("1000.00"),"Transferencia",TipoMovimentoConta.CREDITO);
		MovimentoConta debito1 = new MovimentoConta(LocalDate.of(2020, 1, 10), new BigDecimal("10.00"),"Transferencia",TipoMovimentoConta.DEBITO);
		
		movimentarConta(c12, credito1);
		movimentarConta(c12, debito1);
		persistirNoBanco(em, c12);
		
		
	}

	private static void persistirNoBanco(EntityManager em, Correntista correntista, Conta conta) {
		em.persist(correntista);
		em.persist(conta);
		em.getTransaction().commit();
		em.getTransaction().begin();
		em.clear(); //gambiara para solucionar problema de integração do h2 com o hibernate
	}
	
	private static void persistirNoBanco(EntityManager em, Conta conta) {
		
		em.persist(conta);
		em.getTransaction().commit();
		em.getTransaction().begin();
		em.clear(); //gambiara para solucionar problema de integração do h2 com o hibernate
	}

	private static void imprimirContasNoConsole(Correntista correntista) {
		correntista.getContas().forEach(System.out::println);
		System.out.println(">>>>>>>>>>>>");
	}
	
	private static void movimentarConta(Conta conta, MovimentoConta movimento) {
		if(movimento.getTipo().equals(TipoMovimentoConta.DEBITO)) {
			conta.debitar(movimento.getEfetuadoEm(), movimento.getValor(), movimento.getHistorico());
		}else if(movimento.getTipo().equals(TipoMovimentoConta.CREDITO)) {
			conta.creditar(movimento.getEfetuadoEm(), movimento.getValor(), movimento.getHistorico());
		}
	}

}
