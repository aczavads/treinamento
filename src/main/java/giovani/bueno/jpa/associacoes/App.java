package giovani.bueno.jpa.associacoes;

import java.time.LocalDate;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import giovani.bueno.jpa.CPF;



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

	private static void gerenciarContas(EntityManager em)  throws Exception{
		Correntista cJ = new CorrentistaJuridica("JURIDICAA",new CNPJ("44.405.033/0001-97"),"TESTE",LocalDate.of(2010, 1,10));
		Conta c12 = new Conta(cJ, 12L, LocalDate.of(2020, 1, 10));		
		Conta c15 = new Conta(cJ, 15L, LocalDate.of(2020, 1, 10));		
		Conta c99 = new Conta(cJ, 99L, LocalDate.of(2020, 1, 10));
		
		
		Correntista cF = new CorrentistaFisica("FISICAAA",new CPF("392.350.648-13"),LocalDate.of(2010, 1,10));
		Conta c199 = new Conta(cF, 199L, LocalDate.of(2020, 1, 10));		
		Conta c177 = new Conta(cF, 177L, LocalDate.of(2020, 1, 10));
		
		em.persist(cJ);
		em.persist(c12);
		em.persist(c15);
		em.persist(c99);
		
		em.persist(cF);
		em.persist(c199);
		em.persist(c177);

		
		em.getTransaction().commit();
		em.clear();//gambiarraaaa testar
		em.getTransaction().begin();
		imprimirContasNocConsole(em.find(CorrentistaFisica.class, cF.getId()));
		
	  System.out.println(cJ);
	 
	}

	private static void imprimirContasNocConsole(Correntista josias) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		josias.getContas().forEach(System.out::println);
		
	}

}
