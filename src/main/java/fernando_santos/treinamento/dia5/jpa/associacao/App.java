package fernando_santos.treinamento.dia5.jpa.associacao;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class App {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		try {
			transaction.begin();

			em.createQuery("delete from Conta").executeUpdate();
			em.createQuery("delete from Correntista").executeUpdate();

			gerenciarContas(em);

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			transaction.commit();
		}
	}

	private static void gerenciarContas(EntityManager em) {
		CorrentistaFisica fernando = new CorrentistaFisica("Fernando", new CPF("782.974.710-55"),
				LocalDate.of(2020, 1, 10));
		Conta contaDoFernando = new Conta(fernando, 1L, LocalDate.of(2020, 1, 10));

		em.persist(fernando);
		em.persist(contaDoFernando);

		em.getTransaction().commit();
		em.clear(); /* clear() necessário para realizar join das contas no h2 */
		em.getTransaction().begin();

		Correntista fernandoLocalizado = em.find(Correntista.class, fernando.getId());

		JOptionPane.showMessageDialog(null, fernandoLocalizado);
		System.out.println(fernandoLocalizado);
	}

}
