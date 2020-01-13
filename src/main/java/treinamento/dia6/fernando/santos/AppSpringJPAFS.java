package treinamento.dia6.fernando.santos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppSpringJPAFS implements CommandLineRunner {
	@Autowired
	private EntityManagerFactory factory;
	
	private Logger logger = LoggerFactory.getLogger(AppSpringJPAFS.class);
	
	public static void main(String[] args) {
		SpringApplication.run(AppSpringJPAFS.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Inicializando aplica��o Spring...");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		manager.getTransaction().commit();
		logger.info("Encerrando aplica��o Spring...");
	}

}
