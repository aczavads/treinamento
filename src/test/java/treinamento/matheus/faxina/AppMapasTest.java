package treinamento.matheus.faxina;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import treinamento.dia2.Parcela;
import treinamento.dia2.ParcelamentoComParcela;

public class AppMapasTest {

	@Test
	public void testarMapIguais() {
		LocalDate dataBase = LocalDate.now();
		BigDecimal valorTotal = new BigDecimal("1000.00");
		int diasPrazo = 0;
		int quantidadeParcelas = 12;

		final LocalDate UmDoUm = LocalDate.of(2020, 01, 01);
		final LocalDate UmDoDois = LocalDate.of(2020, 01, 02);
		final LocalDate UmDoTres = LocalDate.of(2020, 01, 03);
		List<Parcela> parcelas = new ArrayList<>();
		parcelas.add(new Parcela(1, UmDoUm, new BigDecimal("100.00")));
		parcelas.add(new Parcela(1, UmDoUm, new BigDecimal("100.00")));
		parcelas.add(new Parcela(1, UmDoDois, new BigDecimal("100.00")));
		parcelas.add(new Parcela(1, UmDoDois, new BigDecimal("100.00")));
		parcelas.add(new Parcela(1, UmDoTres, new BigDecimal("100.00")));
		parcelas.add(new Parcela(1, UmDoTres, new BigDecimal("100.00")));
		parcelas.add(new Parcela(1, UmDoTres, new BigDecimal("100.00")));
		
		Map<LocalDate, List<Parcela>> parcelasAgrupadas = new HashMap<>();
		Set<LocalDate> vencimentos = new HashSet<>();
		vencimentos.add(UmDoUm);
		vencimentos.add(UmDoDois);
		vencimentos.add(UmDoTres);

		assertEquals(Arrays.asList(parcelas.get(0), parcelas.get(1)), parcelasAgrupadas);
		assertEquals(Arrays.asList(parcelas.get(2), parcelas.get(3)), parcelasAgrupadas);
	}

}
