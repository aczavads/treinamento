package treinamento.matheus.faxina;

import static org.junit.Assert.assertSame;

import org.junit.Test;

import treinamento.matheus.faxina.EuSouUmSingleton;

public class EuSouUmSingletonTest {

	@Test
	public void testandoSeESingleton() {
		EuSouUmSingleton euSouUmSigleton1 = EuSouUmSingleton.getInstance();
		EuSouUmSingleton euSouUmSigleton2 = EuSouUmSingleton.getInstance();
		
		assertSame(euSouUmSigleton1, euSouUmSigleton2);
	}

}
