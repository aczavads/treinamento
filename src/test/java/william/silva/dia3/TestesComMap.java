package william.silva.dia3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import treinamento.dia2.Parcela;
import treinamento.dia2.ParcelamentoComParcela;

public class TestesComMap {
	@Test
	public void testarGeradorDeParcelas() {
		List<Parcela> parcelas = App.gerarCemParcelas("1500.00");
		assertEquals(parcelas.size(), 100);
	}
	
	@Test
	public void testarAgrupamentoDeParcelas() {
		LocalDate data1 = LocalDate.of(2020, 02, 14);
		LocalDate data2 = LocalDate.of(2020, 03, 15);
		LocalDate data3 = LocalDate.of(2020, 04, 14);
//		List<Parcela> parcelas = ParcelamentoComParcela.parcelar(new BigDecimal("100.00"), 3, LocalDate.of(2020, 01, 15), 30);
		List<Parcela> parcelasControle = new ArrayList<>();
		parcelasControle.add(new Parcela(1, data1, new BigDecimal("33.34")));
		parcelasControle.add(new Parcela(2, data2, new BigDecimal("33.33")));
		parcelasControle.add(new Parcela(3, data3, new BigDecimal("33.33")));

		Map<LocalDate, List<Parcela>> boletos = App.gerarMapDeParcelas(parcelasControle);
//		App.imprimirMapDeParcelas(boletos);
		Map<LocalDate, List<Parcela>> boletosControle = new HashMap<>();
		boletosControle.put(data1, parcelasControle.subList(0, 1));
		boletosControle.put(data2, parcelasControle.subList(1, 2));
		boletosControle.put(data3, parcelasControle.subList(2, 3));
//		App.imprimirMapDeParcelas(boletosControle);
		
		assertTrue(boletosControle.containsKey(data1));
		assertTrue(boletosControle.containsKey(data2));
		assertTrue(boletosControle.containsKey(data3));
	}
}
