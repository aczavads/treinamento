package treinamento.dia3.fernando.santos.singleton;

import static org.junit.Assert.*;

import org.junit.Test;

import fernando_santos.treinamento.dia3.singleton.FernandoSingleton;

public class FernandoSingletonTest {

	@Test
	public void validarSingleton() {
		FernandoSingleton fernandoSingletonUm = FernandoSingleton.getInstance();
		FernandoSingleton fernandoSingletonDois = FernandoSingleton.getInstance();
		
		assertSame(fernandoSingletonUm, fernandoSingletonDois);
	}

}
