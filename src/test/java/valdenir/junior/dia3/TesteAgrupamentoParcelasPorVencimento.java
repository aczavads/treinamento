package valdenir.junior.dia3;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import treinamento.dia2.Parcela;

public class TesteAgrupamentoParcelasPorVencimento {

	@Test
	public void test() {

		List<Parcela> parcelas = new ArrayList<>();
		parcelas.add(new Parcela(1, LocalDate.of(2020, 1, 1), new BigDecimal("10.00")));
		parcelas.add(new Parcela(2, LocalDate.of(2020, 1, 1), new BigDecimal("20.00")));
		parcelas.add(new Parcela(3, LocalDate.of(2020, 2, 5), new BigDecimal("30.00")));
		parcelas.add(new Parcela(4, LocalDate.of(2020, 2, 5), new BigDecimal("40.00")));
		parcelas.add(new Parcela(5, LocalDate.of(2020, 3, 7), new BigDecimal("50.00")));

		Map<LocalDate, List<Parcela>> parcelasAgrupadas = App.agruparParcelaPorVencimento(parcelas);
		assertEquals(3, parcelasAgrupadas.keySet().size());

		for (LocalDate chave : parcelasAgrupadas.keySet()) {
			for (Parcela parcela : parcelasAgrupadas.get(chave)) {
				assertEquals(chave, parcela.getVencimento());
			}
		}

		assertEquals(Arrays.asList(parcelas.get(0), parcelas.get(1)),
				parcelasAgrupadas.get(parcelas.get(0).getVencimento()));

		assertEquals(Arrays.asList(parcelas.get(2), parcelas.get(3)),
				parcelasAgrupadas.get(parcelas.get(2).getVencimento()));

		assertEquals(Arrays.asList(parcelas.get(4)), parcelasAgrupadas.get(parcelas.get(4).getVencimento()));
	}

}
