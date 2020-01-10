package GLF.dia5.jpa.associacoes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import GLF.dia5.jpa.CPF;




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
			}finally {
				manager.getTransaction().commit();
			}
			System.out.println("Foi.");

		}
		private static void gerenciarContas(EntityManager em) throws Exception {
			Correntista josias = new CorrentistaFisica("Josias Alberto", new CPF("016.769.639-44"),LocalDate.of(2000, 10, 10));
			//Conta c12 = new Conta(josias, 12L, LocalDate.of(2020, 1, 10));		
			//Conta c15 = new Conta(josias, 15L, LocalDate.of(2020, 1, 10));		
			//Conta c99 = new Conta(josias, 99L, LocalDate.of(2020, 1, 10));		

			Correntista matera = new CorrentistaJuridica("Matera", new CNPJ("72.946.869/0001-34"), "MATERA SYSTEMS", LocalDate.of(2000, 10, 10));
			//Conta c199 = new Conta(matera, 199L, LocalDate.of(2020, 1, 10));		
			//Conta c177 = new Conta(matera, 177L, LocalDate.of(2020, 1, 10));		
			
			em.persist(josias);
			//em.persist(c12);
			//em.persist(c15);
			//em.persist(c99);

			em.persist(matera);
			//em.persist(c199);
			//em.persist(c177);

			em.getTransaction().commit();
			em.clear(); 
			em.getTransaction().begin();
			imprimirContasNoConsole(em.find(CorrentistaFisica.class, josias.getId()));
			imprimirContasNoConsole(em.find(CorrentistaJuridica.class, matera.getId()));
		}
		private static void imprimirContasNoConsole(Correntista correntista) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			correntista.getConta().forEach(System.out::println);
		}
		
		
		
	}

