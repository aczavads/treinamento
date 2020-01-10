package schiavon.gabriel.dia5.jpa.associacoes;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppContas {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
		factory.getCache().evictAll();
		EntityManager manager = factory.createEntityManager();
		gerenciarContas(manager);
	}

	private static void gerenciarContas(EntityManager manager) {
		try {
			manager.getTransaction().begin();
//			manager.createQuery("delete from MovimentoConta").executeUpdate();
			manager.createQuery("delete from Conta").executeUpdate();
			manager.createQuery("delete from Correntista").executeUpdate();
			
			PessoaFisica josias = new PessoaFisica("Josias ALberto", new CPF("08944632928"), LocalDate.now());
			Conta c12 = new Conta(12L, LocalDate.now(), josias);
			manager.persist(josias);
			manager.persist(c12);

			PessoaJuridica felipe = new PessoaJuridica("Roberto e Murilo Limpeza ME", new CNPJ("46525110000178"), "Roberto e Murilo Limpeza ME", LocalDate.now());
			Conta c1 = new Conta(1L, LocalDate.now(), felipe);
			manager.persist(felipe);
			manager.persist(c1);
			c1.movimentar(LocalDate.now(), BigDecimal.valueOf(100D), "Isto é um histórico", TipoMovimentoConta.DEBITO);
			c1.movimentar(LocalDate.now(), BigDecimal.valueOf(100D), "Isto é um histórico2", TipoMovimentoConta.CREDITO);
			manager.getTransaction().commit();
			manager.clear();
			manager.getTransaction().begin();
			System.out.println(c1);
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.getTransaction().commit();
		}
	}
}
