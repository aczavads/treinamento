package guscam.dia3.singleton;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesteDoSingleton {

	@Test
	public void testeDaIntanciaDoSingleton() {
		assertSame(Singleton.getInstance(), Singleton.getInstance());
	}

}
