//package treinamento.diegomucheniski.dia5.jpa.associacoes;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//import diegomucheniski.domains.CNPJValido;
//import diegomucheniski.domains.CPFValido;
//import diegomucheniski.domains.Conta;
//import diegomucheniski.domains.Correntista;
//import diegomucheniski.domains.CorrentistaPessoaFisica;
//import diegomucheniski.domains.CorrentistaPessoaJuridica;
//import diegomucheniski.domains.MovimentoConta;
//import diegomucheniski.enums.TipoMovimentoConta;
//
//public class AppAssociacoes {
//	
//	public static void main(String[] args) {
//			
//			EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
//			EntityManager manager = factory.createEntityManager();
//			
//			try {
//				manager.getTransaction().begin();
//				manager.createQuery("delete from Conta").executeUpdate();
//				manager.createQuery("delete from Correntista").executeUpdate();
//				manager.createQuery("delete from CorrentistaPessoaFisica").executeUpdate();
//				manager.createQuery("delete from CorrentistaPessoaJuridica").executeUpdate();
//				gerenciarContasPessoaFisica(manager);
//				gerenciarContasPessoaJuridica(manager);
//			} 
//			catch (Exception e) {
//				manager.getTransaction().rollback();
//				e.printStackTrace();
//			}
//			finally {
//				manager.getTransaction().commit();
//				System.out.println("Processo finalizado");
//			}
//			
//		}
//	
//	private static void gerenciarContasPessoaJuridica(EntityManager manager) {
//		Correntista matera = new CorrentistaPessoaJuridica(new CNPJValido("74.835.731/0001-93"), "MTPR", LocalDate.of(1990, 01, 10), "Matera Systems");
//		Conta contaItau = new Conta(12L, LocalDate.of(2020, 1, 10), matera);
//		imprimirContasNoConsole(matera);		
//		persistirNoBanco(manager, matera, contaItau);
//		
//		matera = manager.find(Correntista.class, matera.getId());		
//		System.out.println("Correntista retornado: " + matera);
//		
//		contaItau = manager.find(Conta.class, contaItau.getId());		
//		System.out.println("Correntista pela Conta: " + contaItau.getCorrentista().getNome());	
//		
//	}
//
//	private static void gerenciarContasPessoaFisica(EntityManager manager) throws Exception {
//		
//		Correntista joao = new CorrentistaPessoaFisica(new CPFValido("217.973.736-09"), LocalDate.of(1954, 12, 24), "João Mucheniski");
//		Conta contaBancoDoBrasil = new Conta(21L, LocalDate.of(2020, 1, 10), joao);			
//		imprimirContasNoConsole(joao);
//		
//		persistirNoBanco(manager, joao, contaBancoDoBrasil);
//		
//		joao = manager.find(Correntista.class, joao.getId());		
//		System.out.println("Correntista retornado: " + joao);
//		
//		contaBancoDoBrasil = manager.find(Conta.class, contaBancoDoBrasil.getId());		
//		System.out.println("Correntista pela Conta: " + contaBancoDoBrasil.getCorrentista().getNome());		
//		
//		MovimentoConta credito1 = new MovimentoConta(LocalDate.of(2020, 1, 10), new BigDecimal("1000.00"), "Transferencia Teste", TipoMovimentoConta.CREDITO);
//		MovimentoConta debito1 = new MovimentoConta(LocalDate.of(2020, 1, 10), new BigDecimal("100.00"), "Transferencia Teste", TipoMovimentoConta.DEBITO);
//		
//		movimentarConta(manager, contaBancoDoBrasil, credito1);
//		movimentarConta(manager, contaBancoDoBrasil, debito1);
//		
//	}
//
//	private static void persistirNoBanco(EntityManager manager, Correntista correntista, Conta conta) {
//		manager.persist(correntista);
//		persistirNoBanco(manager, conta);
//	}
//	
//	private static void persistirNoBanco(EntityManager manager, Conta conta) {		
//		manager.persist(conta);		
//		manager.getTransaction().commit();
//		manager.clear(); // Gambeta por causa do H2
//		manager.getTransaction().begin();
//	}
//
//	private static void imprimirContasNoConsole(Correntista joao) {
//		System.out.println();
//		System.out.println("IMPRESSÃO DAS CONTAS=========================================");
//		joao.getContas().forEach(System.out::println);
//	}
//
//	private static void movimentarConta(EntityManager manager, Conta conta, MovimentoConta movimento) {
//		if (movimento.getTipo().equals(TipoMovimentoConta.DEBITO)) {
//			conta.debitar(movimento.getEfetuadoEm(), movimento.getValor(), movimento.getHistorico());
//		}
//		else if (movimento.getTipo().equals(TipoMovimentoConta.CREDITO)) {
//			conta.creditar(movimento.getEfetuadoEm(), movimento.getValor(), movimento.getHistorico());
//		}		
//		persistirNoBanco(manager, conta);
//	}
//
//}
