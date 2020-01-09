package treinamento.diegomucheniski.dia4.uitl;

import java.time.Duration;
import java.time.Instant;

import javax.swing.JOptionPane;

public class ContadorTempo {

	public static void main(String[] args) {
		Instant started = Instant.now();
		JOptionPane.showMessageDialog(null, "Contando o tempo...");
		Instant finished = Instant.now();
		
		System.out.println("Tempo total: " + Duration.between(started, finished));
	}
	
}
