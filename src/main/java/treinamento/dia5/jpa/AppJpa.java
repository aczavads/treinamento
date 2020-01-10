package treinamento.dia5.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppJpa {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
		System.out.println("Foi.");
	}

}
