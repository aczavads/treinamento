package GLF.dia3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesteSingleton {

	@Test
	public void test() {
		
	assertSame(Singleton.getInstance(), Singleton.getInstance());
		
	}

}
