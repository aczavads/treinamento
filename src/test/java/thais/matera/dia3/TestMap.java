package thais.matera.dia3;

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

import treinamento.dia2.ListaDeParcelasInvalida;
import treinamento.dia2.Parcela;

public class TestMap {

	@Test(expected = ListaDeParcelasInvalida.class)
	public void testarListaDeParcelasVazia() {				
		Map<LocalDate, List<Parcela>> mapa = AppMapas.montarMapa(null);
	}
	
	@Test
	public void testarDataDeVencimento() {
		BigDecimal valor = new BigDecimal("1500.00");
		int quantidadeDeParcelas = 10;
		int prazoEmDias = 30;
		LocalDate dataBase = LocalDate.of(2020, 01, 8);
		
		List<Parcela> parcelas = AppMapas.criarCemParcelas(valor, quantidadeDeParcelas, prazoEmDias, dataBase);
		Map<LocalDate, List<Parcela>> mapa = AppMapas.montarMapa(parcelas);
		
		for(java.util.Map.Entry<LocalDate, List<Parcela>> entry : mapa.entrySet()) {
			List<Parcela> parcelasMesmoVencimento = entry.getValue();
			
			for (Parcela parcela : parcelasMesmoVencimento) {
				assertEquals(entry.getKey(), parcela.getVencimento());
			}
		}
	}

	@Test
	public void test() {
		List<Parcela> parcelas = new ArrayList<>();
		final LocalDate trezeDoUm =  LocalDate.of(2020, 1, 13);
		final LocalDate dezesseteDoDois =  LocalDate.of(2020, 1, 17);
		final LocalDate vinteECincoDoTres =  LocalDate.of(2020, 1, 25);
		
		parcelas.add(new Parcela(1, trezeDoUm, new BigDecimal("1000.00")));
		parcelas.add(new Parcela(2, trezeDoUm, new BigDecimal("2000.00")));
		parcelas.add(new Parcela(3, dezesseteDoDois, new BigDecimal("3000.00")));
		parcelas.add(new Parcela(4, dezesseteDoDois, new BigDecimal("4000.00")));
		parcelas.add(new Parcela(5, dezesseteDoDois, new BigDecimal("5000.00")));
		parcelas.add(new Parcela(6, vinteECincoDoTres, new BigDecimal("6000.00")));
		
		Map<LocalDate, List<Parcela>> parcelasAgrupadas = AppMapas.montarMapa(parcelas);
		
		Set<LocalDate> vencimentos = new HashSet<>();
		vencimentos.add(trezeDoUm);
		vencimentos.add(dezesseteDoDois);
		vencimentos.add(vinteECincoDoTres);
		
		assertEquals(vencimentos, parcelasAgrupadas.keySet());
		
		assertEquals(Arrays.asList(parcelas.get(0), parcelas.get(1)), parcelasAgrupadas.get(trezeDoUm));
		assertEquals(Arrays.asList(parcelas.get(2), parcelas.get(3), parcelas.get(4)), parcelasAgrupadas.get(dezesseteDoDois));
		assertEquals(Arrays.asList(parcelas.get(5)), parcelasAgrupadas.get(vinteECincoDoTres));
	}
}
