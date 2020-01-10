package giovani.bueno.jpa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class AppJpa {
	private static Contrato contrato1;
	 private static Contrato contrato2; 
	
	static {
	   try {
		   contrato1 = new Contrato(new InteiroPositivo(1),LocalDate.of(2020,1,10),new CPF("291.709.100-22"));
		   contrato2 = new Contrato(new InteiroPositivo(2),LocalDate.of(2020,1,11),new CPF("392.350.648-13"));
	   } catch (Exception e) {
		e.printStackTrace();
	}	
	}
	 public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
		EntityManager manager = factory.createEntityManager();
	    
		ContratoRepository repContrato = new ContratoRepository(manager);
		List<Contrato> listContratos  = new ArrayList<>();
		
		try {
			manager.getTransaction().begin();
			manager.createQuery("delete from Contrato");
		    repContrato.inserirContrato(contrato1);
		    repContrato.inserirContrato(contrato2);
		    contrato1.setNumero(new InteiroPositivo(22));
		    repContrato.inserirContrato(contrato1);
		  listContratos =   repContrato.selectAllContratos();
		  listContratos.forEach(System.out::println);
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			manager.getTransaction().commit();
		}
	
		System.out.println("Foi.");
		
	}

}
