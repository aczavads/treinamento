package treinamento.guilhermeperes.dia3;

import static org.junit.Assert.*;

import org.junit.Test;

import treinamento.guilhermeperes.dia3.patterns.singleton.Database;

public class SingletonTest {

	@Test
	public void test() {
		Database d1 = Database.getInstance();
		Database d2 = Database.getInstance();
		
		assertSame(Database.getInstance(), Database.getInstance());
		assertSame(d1, Database.getInstance());
		assertSame(d1, d2);
	}

}
