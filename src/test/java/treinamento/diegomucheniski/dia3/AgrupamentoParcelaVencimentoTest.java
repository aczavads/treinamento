package treinamento.diegomucheniski.dia3;

import static org.junit.Assert.assertEquals;

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

public class AgrupamentoParcelaVencimentoTest {

	@Test
	public void deveAgruparParcelasPorVencimento() {
	
		List<Parcela> parcelas = new ArrayList<>();
		
		final LocalDate trezeDoUm = LocalDate.of(2020, 1, 13);
		final LocalDate dezesseteDoDois = LocalDate.of(2020, 2, 17);
		final LocalDate vinteCincoDoTrez = LocalDate.of(2020, 3, 25);
		
		parcelas.add(new Parcela(1, trezeDoUm, new BigDecimal("1000.00")));
		parcelas.add(new Parcela(2, trezeDoUm, new BigDecimal("2000.00")));
		parcelas.add(new Parcela(3, dezesseteDoDois, new BigDecimal("3000.00")));
		parcelas.add(new Parcela(4, dezesseteDoDois, new BigDecimal("4000.00")));
		parcelas.add(new Parcela(5, vinteCincoDoTrez, new BigDecimal("5000.00")));
		parcelas.add(new Parcela(6, vinteCincoDoTrez, new BigDecimal("6000.00")));
		
		Map<LocalDate, List<Parcela>> parcelasAgrupadas = AgrupamentoParcelaVencimento.agrupar(parcelas);
		
		Set<LocalDate> vencimentos = new HashSet<>();
		vencimentos.add(trezeDoUm);
		vencimentos.add(dezesseteDoDois);
		vencimentos.add(vinteCincoDoTrez);
		
		// Verifico se as parcelas agrupadas são as do range passado
		assertEquals(vencimentos, parcelasAgrupadas.keySet());
		
		// Verifico se as duas parcelas são a da data passada
		assertEquals(Arrays.asList(parcelas.get(0), parcelas.get(1)), parcelasAgrupadas.get(trezeDoUm));
		assertEquals(Arrays.asList(parcelas.get(2), parcelas.get(3)), parcelasAgrupadas.get(dezesseteDoDois));
		assertEquals(Arrays.asList(parcelas.get(4), parcelas.get(5)), parcelasAgrupadas.get(vinteCincoDoTrez));
		
	}

}
