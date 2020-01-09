package treinamento.dia3.singleton;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestesSingleton {

	
	@Test
	public void testSame() {
		assertSame(Universo.getInstance(), Universo.getInstance());
	}

}
