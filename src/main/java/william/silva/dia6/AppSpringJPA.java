package william.silva.dia6;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class AppSpringJPA implements CommandLineRunner {
	@Autowired
	private EntityManagerFactory factory;
	
	private Logger logger = LoggerFactory.getLogger(AppSpringJPA.class);
	
	public static void main(String[] args) {
		SpringApplication.run(AppSpringJPA.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Inicializando aplicação Spring...");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		manager.getTransaction().commit();
		logger.info("Encerrando aplicação Spring...");
	}

}

