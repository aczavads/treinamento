package thyagofranco.dia2;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.security.auth.x500.X500Principal;

public class AppStreams {
	public static void main(String[] args) {
		
		double soma = Stream.of(4.5,2.9,3.5,4.9,5.1)
			.reduce(0.0,(Double acc, Double elemento) -> acc + elemento);
		
		System.out.println(soma);
		
		
		
		
		
	}
}