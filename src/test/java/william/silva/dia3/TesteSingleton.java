package william.silva.dia3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import william.dia3.William;

public class TesteSingleton {
	@Test
	public void testarSingletonUnico() {
		William w1 = William.getInstance();
		William w2 = William.getInstance();
		assertSame(w1, w2);
		
		Set<William> conjunto = new HashSet();
		for (int i = 0; i < 1000; i++) {
			conjunto.add(William.getInstance());
		}
		assertEquals(conjunto.size(), 1);

	}
}
