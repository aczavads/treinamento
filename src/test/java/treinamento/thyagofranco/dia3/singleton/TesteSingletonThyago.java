package treinamento.thyagofranco.dia3.singleton;

import static org.junit.Assert.assertSame;

import org.junit.Test;

import treinamento.thyagofranco.dia3.designpatterns.singleton.Thyago;

public class TesteSingletonThyago {

	@Test
	public void test() {
		
		Thyago thyago1 = Thyago.getInstance();
		Thyago thyago2 = Thyago.getInstance();
		
		assertSame(thyago1, thyago2);
		
	}
	
	

}
