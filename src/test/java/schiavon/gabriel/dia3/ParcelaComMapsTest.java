package schiavon.gabriel.dia3;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class ParcelaComMapsTest {

	@Test
	public void dadoGeracaoVariasParcelasEntaoElasDevemSerAgrupadasPorDiaDeVencimento() {
		List<Parcela> parcelas = gerarParcelas();
		Map<LocalDate, List<Parcela>> mapsParcelaGerado = AppMaps.consolidarParcelas(parcelas);

		Set<LocalDate> vencimentos = new HashSet<>();
		vencimentos.add(LocalDate.of(2020, 1, 13));
		vencimentos.add(LocalDate.of(2020, 2, 17));
		vencimentos.add(LocalDate.of(2020, 3, 25));
		Map<LocalDate, List<Parcela>> mapsEsperado = gerarMapEsperado();

		
	}

	private Map<LocalDate, List<Parcela>> gerarMapEsperado() {
		final LocalDate onzeUm = LocalDate.of(2020, 1, 11);
		final LocalDate vinteUm = LocalDate.of(2020, 1, 21);
		Map<LocalDate, List<Parcela>> mapsEsperado = new HashMap<>();
		mapsEsperado.put(LocalDate.of(2020, 1, 11), new ArrayList<Parcela>());
		mapsEsperado.get(onzeUm).add(new Parcela(1, onzeUm, new BigDecimal("50.00")));
		mapsEsperado.get(onzeUm).add(new Parcela(1, onzeUm, new BigDecimal("50.00")));

		mapsEsperado.put(LocalDate.of(2020, 1, 21), new ArrayList<Parcela>());
		mapsEsperado.get(vinteUm).add(new Parcela(2, vinteUm, new BigDecimal("50.00")));
		mapsEsperado.get(vinteUm).add(new Parcela(2, vinteUm, new BigDecimal("50.00")));

		return mapsEsperado;
	}

	private static List<Parcela> gerarParcelas() {
		List<Parcela> parcelas = new ArrayList<>();

		final LocalDate trezeUm = LocalDate.of(2020, 1, 13);
		final LocalDate dezesseteDois = LocalDate.of(2020, 2, 17);
		final LocalDate vinteCincoTres = LocalDate.of(2020, 3, 25);

		parcelas.add(new Parcela(1, trezeUm, new BigDecimal("1000.00")));
		parcelas.add(new Parcela(2, trezeUm, new BigDecimal("2000.00")));
		parcelas.add(new Parcela(3, dezesseteDois, new BigDecimal("3000.00")));
		parcelas.add(new Parcela(4, dezesseteDois, new BigDecimal("4000.00")));
		parcelas.add(new Parcela(5, dezesseteDois, new BigDecimal("5000.00")));
		parcelas.add(new Parcela(6, vinteCincoTres, new BigDecimal("6000.00")));

		return parcelas;
	}

}
