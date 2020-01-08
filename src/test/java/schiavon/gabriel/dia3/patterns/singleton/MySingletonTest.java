package schiavon.gabriel.dia3.patterns.singleton;

import static org.junit.Assert.*;

import org.junit.Test;

public class MySingletonTest {

	@Test
	public void verificaUnicidadeSingleton() {
		MySingleton singleton1 = MySingleton.getInstance();
		MySingleton singleton2 = MySingleton.getInstance();
		
		assertSame(singleton1, singleton2);
	}
	
}
