package schiavon.gabriel.dia5.jpa;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class AppJpa {
	private static Contrato contrato1;
	private static Contrato contrato2;
	private static Contrato contrato3;
	private static EntityManager manager;
	
	static {
		try {
			contrato1 = new Contrato(new IntegerPositivo(1), LocalDate.of(2020, 1, 10), new CPF("08944632928"));
			contrato2 = new Contrato(new IntegerPositivo(2), LocalDate.of(2020, 1, 10), new CPF("08944632928"));
			contrato3 = new Contrato(new IntegerPositivo(3), LocalDate.of(2020, 1, 10), new CPF("08944632928"));
			manager = Persistence.createEntityManagerFactory("pu").createEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ContratoRepository repository = new ContratoRepository(manager);
		deleteAll(repository);
		salvar(repository, contrato1);
		salvar(repository, contrato2);
		salvar(repository, contrato3);
		contrato1.setNumero(new IntegerPositivo(11));
		deletar(repository, contrato2.getId());
		deletar(repository, contrato3);
		repository.selectAll().forEach(System.out::println);
	}
	
	private static void deleteAll(ContratoRepository repository) {
		try {
			manager.getTransaction().begin();
			repository.deleteAll();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.getTransaction().commit();
		}
	}

	private static void deletar(ContratoRepository repository, Object objeto) {
		try {
			manager.getTransaction().begin();
			repository.delete(objeto);
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.getTransaction().commit();
		}
	}
	
	private static void deletar(ContratoRepository repository, UUID id) {
		try {
			manager.getTransaction().begin();
			repository.delete(id);
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.getTransaction().commit();
		}
	}

	private static void salvar(ContratoRepository repository, Object objeto) {
		try {
			manager.getTransaction().begin();
			repository.insertOrUpdate(objeto);
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.getTransaction().commit();
		}
	}

}
