package guscam.dia6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import guscam.dia6.Livro.Livro2Service;
import guscam.dia6.Livro.MeuLogger;
import guscam.dia6.Motor.Motor;
import guscam.dia6.Motor.Veiculo;

@SpringBootApplication
public class AppLivro2 implements CommandLineRunner {
	@Autowired
	private Livro2Service service;
	
	@Autowired
	private Veiculo veiculo;
	
	public static void main(String[] args) {
		SpringApplication.run(AppLivro2.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("########################>>>>>>>>>>>>");
//		service.gerarLoteDeLivros();
//		service.findAll().forEach(System.out::println);;
		System.out.println(veiculo.ligar());
	}
	
	@Bean
	public MeuLogger criarMeuLogger() {
		return new MeuLogger();
	}
}
