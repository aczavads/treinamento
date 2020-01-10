package william.silva.dia5;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import treinamento.dia5.jpa.Pedido;

public class AppJpa {
	private static CPF cpfRandom = new CPF(ValidaCpf.getInstance().cpf(true));
	private static Contrato contrato1 = new Contrato(new CPF("081.012.039-90"),new InteiroPositivo(1), LocalDate.of(2021, 1, 10));
	private static Contrato contrato2 = new Contrato(new CPF("400.677.930-53"),new InteiroPositivo(2), LocalDate.of(2022, 1, 11));
	private static Contrato contrato3 = new Contrato(cpfRandom,new InteiroPositivo(5), LocalDate.of(2022, 1, 13));

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
		EntityManager manager = factory.createEntityManager();
		ContratoRepository contratoRepository = new ContratoRepository(manager);

		try {
			manager.getTransaction().begin();
			
//			manager.createQuery("delete from Contrato").executeUpdate();
//			manager.createNativeQuery("delete from contrato").executeUpdate();
//			manager.createNamedQuery("delete_contrato").executeUpdate();
			
			contratoRepository.clearAll();
			contratoRepository.Insert(contrato1);
			contratoRepository.Insert(contrato2);
			contratoRepository.Insert(contrato3);
			contrato1.setNumero(new InteiroPositivo(2313));
			contratoRepository.update(contrato1);
			
			contrato2.setCpfDoTitular(new CPF("111.116.100-37"));
			contratoRepository.update(contrato2);
			
			contratoRepository.selectAll().forEach(c -> System.out.println(c));
			
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			manager.getTransaction().commit();
		}
		System.out.println("Foi.");
	}

}
