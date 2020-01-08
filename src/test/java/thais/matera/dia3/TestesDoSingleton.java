package thais.matera.dia3;

import static org.junit.Assert.assertSame;

import org.junit.Test;

import thais.matera.dia3.singleton.Universo;

public class TestesDoSingleton {

	@Test
	public void TestarSingleton() {
		int terminar = 1000;
		
		Universo u1 = Universo.getInstance();
		Universo u2 = Universo.getInstance();

		assertSame(u1, u2);
	}
}
