//package treinamento.diegomucheniski.dia6.livro;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//
//@SpringBootApplication
//public class AppLivroMucheniski implements CommandLineRunner {
//	
//	@Autowired
//	private LivroMucheniskiService livroService;
//	
//	public static void main(String[] args) {
//		SpringApplication.run(AppLivroMucheniski.class, args);
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		livroService.gerarLoteTeste();
//		livroService.findAll().forEach(System.out::println);
//	}
//	
//	@Bean
//	public MeuLogger criarMeuLogger() {
//		return new MeuLogger();
//	}
//
//}
