package treinamento.dia2;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestesDoParcelamentoComParcela {

	@Test
	public void testarParcelasIguais() {
		Parcela p1 = new Parcela(1, LocalDate.of(2020, 1, 10), new BigDecimal("100.33"));
		Parcela p2 = new Parcela(1, LocalDate.of(2020, 1, 10), new BigDecimal("100.33"));
		
		assertEquals(p1, p2);
	}
	
	@Test(expected = NumeroDeParcelasInvalido.class)
	public void testarNumeroDeParcelasInvalido() {
		ParcelamentoComParcela.parcelar(new BigDecimal("100.00"), -9, LocalDate.of(2020, 1, 10), 30);
	}

	@Test(expected = ValorAParcelarInvalido.class)
	public void testarValorInvalidoNegativo() {
		ParcelamentoComParcela.parcelar(new BigDecimal("-100.00"), 3, LocalDate.of(2020, 1, 10), 30);
	}

	@Test(expected = ValorAParcelarInvalido.class)
	public void testarValorInvalidoCasasDecimais() {
		ParcelamentoComParcela.parcelar(new BigDecimal("100.0003"), 3, LocalDate.of(2020, 1, 10), 30);
	}

	@Test
	public void testarParcelamentoComParcelasIguais() {
		BigDecimal valor = new BigDecimal("100.00");
		int quantidadeDeParcelas = 2;

		LocalDate dataBase = LocalDate.of(2020, 1, 10);
		int prazoEmDias = 30;
		List<Parcela> parcelas = ParcelamentoComParcela.parcelar(valor, quantidadeDeParcelas, dataBase, prazoEmDias);

		List<Parcela> listaEsperada = new ArrayList<>();
		listaEsperada.add(new Parcela(1, dataBase.plusDays(prazoEmDias), new BigDecimal("50.00")));
		listaEsperada.add(new Parcela(2, dataBase.plusDays(2*prazoEmDias), new BigDecimal("50.00")));
		
		assertEquals(listaEsperada, parcelas);
	}

	@Test
	public void testarParcelamentoComParcelasDiferentes() {
		BigDecimal valor = new BigDecimal("100.00");
		int quantidadeDeParcelas = 3;

		LocalDate dataBase = LocalDate.of(2020, 1, 10);
		int prazoEmDias = 30;
		List<Parcela> parcelas = ParcelamentoComParcela.parcelar(valor, quantidadeDeParcelas, dataBase, prazoEmDias);

		List<Parcela> listaEsperada = new ArrayList<>();
		listaEsperada.add(new Parcela(1, dataBase.plusDays(prazoEmDias), new BigDecimal("33.34")));
		listaEsperada.add(new Parcela(2, dataBase.plusDays(2*prazoEmDias), new BigDecimal("33.33")));
		listaEsperada.add(new Parcela(3, dataBase.plusDays(3*prazoEmDias), new BigDecimal("33.33")));
		
		assertEquals(listaEsperada, parcelas);
	}
	

}
