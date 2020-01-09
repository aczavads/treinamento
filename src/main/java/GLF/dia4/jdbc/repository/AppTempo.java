package GLF.dia4.jdbc.repository;

import java.time.Duration;
import java.time.Instant;

import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

public class AppTempo {
	
	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();
		JOptionPane.showMessageDialog(null, "ESPERANDO...");
		System.out.println("Tempo total: " +(System.currentTimeMillis()-inicio));
		
		Instant started = Instant.now();
		JOptionPane.showMessageDialog(null, "ESPERANDO....");
		Instant finished = Instant.now();
		System.out.println("Tempo total: " +Duration.between(started, finished).toMillis());
	}
}
