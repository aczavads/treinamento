package william.dia5.GenericEntity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sound.midi.Soundbank;

import william.silva.dia5.CPF;
import william.silva.dia5.ValidaCpf;

public class App {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
		EntityManager manager = factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.createNativeQuery("delete from Conta").executeUpdate();
			manager.createNativeQuery("delete from CORRENTISTAFISICA ").executeUpdate();
			manager.createNativeQuery("delete from CORRENTISTAJURIDICA").executeUpdate();
			manager.createNativeQuery("delete from Correntista").executeUpdate();
			manager.getTransaction().commit();
			gerenciarContas(manager);
		} catch (Exception e) {
			System.out.println("============================================================================caiu no catch");
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally {
//			manager.getTransaction().commit();
		}
		System.out.println("--------------------> Fim!");
	}

	private static void gerenciarContas(EntityManager manager) {
		CPF cpf1 = new CPF("081.012.039-90");
		CPF cpf2 = new CPF(ValidaCpf.getInstance().cpf(true));
		CPF cpf3 = new CPF(ValidaCpf.getInstance().cpf(true));
		CNPJ cnpj1 = new CNPJ(ValidaCpf.getInstance().cnpj(true));
		CNPJ cnpj2 = new CNPJ(ValidaCpf.getInstance().cnpj(true));
		
		CorrentistaFisica william = new CorrentistaFisica(cpf1,LocalDate.of(1992, 1, 10), "W. Douglas Costa");
		CorrentistaFisica douglas = new CorrentistaFisica(cpf2,LocalDate.of(1994, 10, 1), "Douglas Silva");
		CorrentistaFisica lilian = new CorrentistaFisica(cpf3,LocalDate.of(2002,12, 7), "Lilian Lit");
		CorrentistaJuridica matera = new CorrentistaJuridica(cnpj1, "MTR INFORMATICA",LocalDate.of(1994, 10, 1), "MATERA");
		CorrentistaJuridica ipiranga = new CorrentistaJuridica(cnpj2, "IPIRANGA COMBUSTIVEIS",LocalDate.of(1984, 11, 11), "POSTO IPIRANGA");
		Conta c1 = new Conta(7180L, LocalDate.of(2012, 3, 20), william);
		Conta c2 = new Conta(233L, LocalDate.of(2018, 12, 14), douglas);
		Conta c3 = new Conta(643L, LocalDate.of(2014, 2, 14), lilian);
		Conta c4 = new Conta(865L, LocalDate.of(2015, 4, 15), william);
		Conta c5 = new Conta(352L, LocalDate.of(2016, 6, 17), william);
//		
		manager.getTransaction().begin();
		manager.persist(william);
		manager.persist(douglas);
		manager.persist(lilian);
		manager.persist(matera);
		manager.persist(ipiranga);
		manager.persist(c1);
		manager.persist(c2);
		manager.persist(c3);
		manager.persist(c4);
		manager.persist(c5);
		
		
		manager.getTransaction().commit();
//		manager.clear();
//		manager.getTransaction().begin();
		System.out.println("------------------------------------------------inicio");
//		List<Correntista> correntistas = manager.createNativeQuery("select * from Correntista", CorrentistaJuridica.class).getResultList();
		Correntista correntista = manager.find(CorrentistaJuridica.class, matera.getId());
		correntista.getContas().forEach(c -> System.out.println(c));
//		correntistas.forEach(a -> System.out.println(a));
		System.out.println("------------------------------------------------fim");
//		manager.getTransaction().commit();
		
		
		
	}
	
	
}
