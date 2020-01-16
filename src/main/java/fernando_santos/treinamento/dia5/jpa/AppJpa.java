package fernando_santos.treinamento.dia5.jpa;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class AppJpa {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();

//			em.createQuery("delete from Contrato").executeUpdate();
//			em.createNativeQuery("delete from contrato").executeUpdate();
			em.createNamedQuery("delete_contrato").executeUpdate();

			em.persist(new Contrato(new InteiroPositivo(1), LocalDate.of(2020, 1, 10)));

			Contrato contrato2 = new Contrato(new InteiroPositivo(2), LocalDate.of(2020, 1, 10));
			em.persist(contrato2);

			transaction.commit();
			transaction.begin();

			JOptionPane.showMessageDialog(null, "Continuar...");

//			em.remove(contrato2);
			em.createQuery("delete from Contrato c where c.id = :id").setParameter("id", contrato2.getId())
					.executeUpdate();

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			transaction.commit();
		}

		try {
			// com repository
			ContratoRepository contratoRepository = new ContratoRepository(em);
			Contrato contrato3 = new Contrato(new InteiroPositivo(3), LocalDate.of(2020, 1, 10));

			transaction.begin();
			
			contratoRepository.save(contrato3);
			Contrato contrato3Localizado = contratoRepository.findById(contrato3.getId());
			
			JOptionPane.showMessageDialog(null, contrato3Localizado);
			
			contrato3.setEmissao(LocalDate.of(2020, 1, 9));
			
			contratoRepository.save(contrato3);
			
			Contrato contrato3LocalizadoDeNovo = contratoRepository.findById(contrato3.getId());
			
			JOptionPane.showMessageDialog(null, contrato3LocalizadoDeNovo);
			
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			transaction.commit();
		}
		
		CPF cpf = new CPF("886.672.910-80");
		JOptionPane.showMessageDialog(null, cpf.getValor());
	}

}
