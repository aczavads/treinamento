package treinamento.guilhermeperes.dia3;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class TestandoAgrupamentoDeParcelas {

	@Test
	public void test() {
		final List<Parcela> parcelas = new ArrayList<>();
		final Set<LocalDate> vencimentos = new HashSet<>();
		
		final LocalDate primeiroVencimento = LocalDate.of(2020, 1, 8);
		final LocalDate segundoVencimento = LocalDate.of(2020, 2, 8);
		final LocalDate terceiroVencimento = LocalDate.of(2020, 3, 8);
		
		vencimentos.add(primeiroVencimento);
		vencimentos.add(segundoVencimento);
		vencimentos.add(terceiroVencimento);
		
		parcelas.add(new Parcela(1, primeiroVencimento, new BigDecimal("1000.00")));
		parcelas.add(new Parcela(2, primeiroVencimento, new BigDecimal("1000.00")));
		parcelas.add(new Parcela(3, primeiroVencimento, new BigDecimal("1000.00")));
		parcelas.add(new Parcela(1, segundoVencimento, new BigDecimal("1000.00")));
		parcelas.add(new Parcela(2, segundoVencimento, new BigDecimal("1000.00")));
		parcelas.add(new Parcela(3, segundoVencimento, new BigDecimal("1000.00")));
		parcelas.add(new Parcela(1, terceiroVencimento, new BigDecimal("1000.00")));
		parcelas.add(new Parcela(2, terceiroVencimento, new BigDecimal("1000.00")));
		parcelas.add(new Parcela(3, terceiroVencimento, new BigDecimal("1000.00")));
		
		final Map<LocalDate, List<Parcela>> mapa = AppAgrupamentoParcelas.agrupar(parcelas);
		
		assertEquals(mapa.keySet(), vencimentos);
	}

}
