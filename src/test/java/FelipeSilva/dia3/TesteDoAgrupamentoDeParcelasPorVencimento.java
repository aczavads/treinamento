package FelipeSilva.dia3;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import treinamento.dia1.App;
import treinamento.dia2.Parcela;

public class TesteDoAgrupamentoDeParcelasPorVencimento {
	@Test
public void test() {
	List<Parcela> parcelas = new ArrayList<>();
	final LocalDate trezeDoUm = LocalDate.of(2020, 1, 13);
	final LocalDate dezesseteDoDois = LocalDate.of(2020, 2, 17);
	final LocalDate vinteCincoDoTres = LocalDate.of(2020, 3, 25);
	parcelas.add(new Parcela(1, trezeDoUm, new BigDecimal("100")));
	parcelas.add(new Parcela(2, trezeDoUm, new BigDecimal("200")));
	parcelas.add(new Parcela(3, dezesseteDoDois, new BigDecimal("300")));
	parcelas.add(new Parcela(4, dezesseteDoDois, new BigDecimal("400")));
	parcelas.add(new Parcela(5, dezesseteDoDois, new BigDecimal("500")));
	parcelas.add(new Parcela(6, vinteCincoDoTres, new BigDecimal("600")));
	
	Map<LocalDate, List<Parcela>> parcelasAgrupadas = AppMapParcelas.agruparParcelasPorVencimento(parcelas);
	Set<LocalDate> vencimento = new HashSet<>();
	vencimento.add(trezeDoUm);
	vencimento.add(dezesseteDoDois);
	vencimento.add(vinteCincoDoTres);
	assertEquals(vencimento,parcelasAgrupadas.keySet());
	
	
	assertEquals(Array.asList(parcelas.get(0), parcelas.get(1)),
			parcelasAgrupadas.get(trezeDoUm));
	assertEquals(Array.asList(parcelas.get(2), parcelas.get(3), parcelas.get(4)),
			parcelasAgrupadas.get(dezesseteDoDois));
	assertEquals(Array.asList(parcelas.get(5)),
			parcelasAgrupadas.get(vinteCincoDoTres));
	
	
	}
}
