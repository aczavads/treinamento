package treinamento.singleton;

import static org.junit.Assert.*;

import org.junit.Test;

import treinamento.diegomucheniski.dia3.singleton.RickSanchesSingleton;

public class RickSanchesSingletonTest {

	@Test
	public void deveRetornarApenasUmRickComEquals() {
		assertEquals(RickSanchesSingleton.getInstance(), RickSanchesSingleton.getInstance());
	}
	
	@Test
	public void deveRetornarApenasUmRickComSame() {
		assertSame(RickSanchesSingleton.getInstance(), RickSanchesSingleton.getInstance());
	}
	
	@Test
	public void deveRetornarAFrase() {		
		assertEquals("I'M A PICKLE RIIICK!!!", RickSanchesSingleton.turnAPicle());
	}

}
