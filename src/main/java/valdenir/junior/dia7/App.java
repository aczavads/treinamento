package valdenir.junior.dia7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
	public static void main(String[] args) {
		String msgErro = "Código inserido é invalido.";
		String[] pai = "1".split("\\.");
		String[] filho = "1.01".split("\\.");
//		if ((pai.length + 1) != filho.length)
//			throw new RuntimeException(msgErro);
//		for (int i = 0; i < pai.length; i++) {
//			if (!pai[i].equals(filho[i]))
//				throw new RuntimeException(msgErro);
//		}
		SpringApplication.run(App.class, args);
	}
}
