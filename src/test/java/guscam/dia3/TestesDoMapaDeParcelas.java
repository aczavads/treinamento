package guscam.dia3;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import treinamento.dia2.Parcela;

public class TestesDoMapaDeParcelas {

	@Test
	public void testarDatasChavesDoVencimento() {
		final LocalDate dezDoUm =  LocalDate.of(2020, 1, 10);
		final LocalDate quinzeDoDois =  LocalDate.of(2020, 2, 15);
		final LocalDate vinteDoTres =  LocalDate.of(2020, 3, 20);
		
		List<Parcela> parcelas = new ArrayList<Parcela>();
		parcelas.add(new Parcela(1, dezDoUm, new BigDecimal("100.33")));
		parcelas.add(new Parcela(2, dezDoUm, new BigDecimal("200.33")));
		parcelas.add(new Parcela(3, quinzeDoDois, new BigDecimal("300.33")));
		parcelas.add(new Parcela(4, quinzeDoDois, new BigDecimal("400.33")));
		parcelas.add(new Parcela(5, quinzeDoDois, new BigDecimal("500.33")));
		parcelas.add(new Parcela(6, vinteDoTres, new BigDecimal("600.33")));
		
		Map<LocalDate, List<Parcela>> parcelasAgrupadas = MapaDeParcelas.retornarParcelasPorVencimento(parcelas);
		Set<LocalDate> datasEsperadas = new HashSet<>();
		datasEsperadas.add(dezDoUm);
		datasEsperadas.add(quinzeDoDois);
		datasEsperadas.add(vinteDoTres);
		
		assertEquals(datasEsperadas, parcelasAgrupadas.keySet());
		assertEquals(Arrays.asList(parcelas.get(0), parcelas.get(1)), parcelasAgrupadas.get(dezDoUm));
		assertEquals(Arrays.asList(parcelas.get(2), parcelas.get(3), parcelas.get(4)), parcelasAgrupadas.get(quinzeDoDois));
		assertEquals(Arrays.asList(parcelas.get(5)), parcelasAgrupadas.get(vinteDoTres));
	}

}
