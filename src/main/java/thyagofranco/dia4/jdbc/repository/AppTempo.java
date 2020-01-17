package thyagofranco.dia4.jdbc.repository;

import java.time.Duration;
import java.time.Instant;

import javax.swing.JOptionPane;

public class AppTempo {
	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();
		JOptionPane.showMessageDialog(null, "Esperando...");
		System.out.println("Tempo total:" + (System.currentTimeMillis()));
		
		
		Instant started = Instant.now();
		JOptionPane.showMessageDialog(null, "Esperando........");
		Instant finished = Instant.now();
		
		System.out.println("Tempo total: " + Duration.between(started, finished).toMillis());
	}
}
