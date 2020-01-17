package thyagofranco.dia5;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import thyagofranco.dia5.repository.ContratoRepository;

public class AppContratoRepository {

	private static Contrato contrato1;
	private static Contrato contrato2;
	
	private static EntityManagerFactory factory = null;
	private static EntityManager manager = null;
	
	
	static {
		try {
			contrato1 = new Contrato(
					new InteiroPositivo(1), LocalDate.of(2020, 1, 10),new CPF("218.575.178-65"));
			contrato2 = new Contrato(
					new InteiroPositivo(2), LocalDate.of(2020, 1, 10),new CPF("468.224.157-50"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {

		try {
			
			factory = Persistence.createEntityManagerFactory("pu");
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.createQuery("delete from Contrato").executeUpdate(); //limpar o banco
			
			ContratoRepository repo = new ContratoRepository(manager);
			
			repo.save(contrato1);
			repo.save(contrato2);
			contrato1.setNumero(new InteiroPositivo(22));
			repo.delete(contrato2.getId());
			
			
			repo.findAll().forEach(System.out::println);
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
			

			
						

			// System.out.println(contratoRepository.selectAll());

		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();

		} finally {
			manager.getTransaction().commit();
		}

	}

}
