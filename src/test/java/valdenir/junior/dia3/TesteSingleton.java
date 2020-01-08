package valdenir.junior.dia3;

import static org.junit.Assert.assertSame;

import org.junit.Test;

public class TesteSingleton {

	@Test
	public void test() {
		Universo u1 = Universo.getInstance();
		Universo u2 = Universo.getInstance();

		assertSame(u1, u2);
	}
}
