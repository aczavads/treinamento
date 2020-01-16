package william.Repository;

import java.time.Duration;
import java.time.Instant;

public class AppTempo {
public static void main(String[] args) {
	long inicio = System.currentTimeMillis();
	
	Instant started = Instant.now();
	Instant finish = Instant.now();
	
	Duration.between(started, finish);
}
}
