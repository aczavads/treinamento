package treinamento.dia2;

import static org.junit.Assert.assertArrayEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class TestesDoParcelamentoComArray {

	@Test(expected = NumeroDeParcelasInvalido.class)
	public void testarNumeroDeParcelasInvalido() {
		ParcelamentoComArray.parcelar(new BigDecimal("100.00"), -9);
	}

	@Test(expected = ValorAParcelarInvalido.class)
	public void testarValorInvalidoNegativo() {
		ParcelamentoComArray.parcelar(new BigDecimal("-100.00"), 3);
	}

	@Test(expected = ValorAParcelarInvalido.class)
	public void testarValorInvalidoCasasDecimais() {
		ParcelamentoComArray.parcelar(new BigDecimal("100.0003"), 3);
	}

	@Test
	public void testarParcelamentoComParcelasIguais() {
		BigDecimal valor = new BigDecimal("100.00");
		int quantidadeDeParcelas = 2;

		BigDecimal[] parcelas = ParcelamentoComArray.parcelar(valor, quantidadeDeParcelas);

		assertArrayEquals(new BigDecimal[] { new BigDecimal("50.00"), new BigDecimal("50.00") }, parcelas);
	}

	@Test
	public void testarParcelamentoComParcelasDiferentes() {
		BigDecimal valor = new BigDecimal("100.00");
		int quantidadeDeParcelas = 3;

		BigDecimal[] parcelas = ParcelamentoComArray.parcelar(valor, quantidadeDeParcelas);

		assertArrayEquals(
				new BigDecimal[] { new BigDecimal("33.34"), new BigDecimal("33.33"), new BigDecimal("33.33") },
				parcelas);
	}
}
