package treinamento.dia2.fernando.santos.parcelamento;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import treinamento.dia2.fernando.santos.parcelamento.Parcela;
import treinamento.dia2.fernando.santos.parcelamento.Parcelador;
import treinamento.dia2.fernando.santos.parcelamento.QuantidadeDeParcelasComValorInvalidoException;
import treinamento.dia2.fernando.santos.parcelamento.ValorTotalAParcelarComValorInvalidoException;

public class ParceladorTest {

	@Test
	public void testarParcelamentoComParcelasIguais() {
		List<Parcela> parcelamento = new Parcelador().realizaParcelamento(100, 3, "07/01/2020", 30);

		BigDecimal valorTotalDoParcelamento = BigDecimal.ZERO;
		for (int parcela = 0; parcela < parcelamento.size(); parcela++) {
			valorTotalDoParcelamento = valorTotalDoParcelamento.add(parcelamento.get(parcela).getValorDaParcela());
		}

		Parcela parcela1 = new Parcela(1, LocalDate.of(2020, 1, 7), BigDecimal.valueOf(33.34));
		Parcela parcela2 = new Parcela(2, LocalDate.of(2020, 2, 6), BigDecimal.valueOf(33.33));
		Parcela parcela3 = new Parcela(3, LocalDate.of(2020, 3, 7), BigDecimal.valueOf(33.33));
		List<Parcela> objetoParcelamento = new ArrayList<>();
		objetoParcelamento.add(parcela1);
		objetoParcelamento.add(parcela2);
		objetoParcelamento.add(parcela3);

		assertEquals(new BigDecimal("100.00"), valorTotalDoParcelamento);
		assertEquals(3, parcelamento.size());
		assertEquals(objetoParcelamento, parcelamento);

		parcelamento = new Parcelador().realizaParcelamento(300, 3, "07/01/2020", 30);

		parcela1 = new Parcela(1, LocalDate.of(2020, 1, 7), BigDecimal.valueOf(100.00).setScale(2));
		parcela2 = new Parcela(2, LocalDate.of(2020, 2, 6), BigDecimal.valueOf(100.00).setScale(2));
		parcela3 = new Parcela(3, LocalDate.of(2020, 3, 7), BigDecimal.valueOf(100.00).setScale(2));
		objetoParcelamento.clear();
		objetoParcelamento.add(parcela1);
		objetoParcelamento.add(parcela2);
		objetoParcelamento.add(parcela3);

		imprimeParcelamento(parcelamento);
		imprimeParcelamento(objetoParcelamento);

		assertEquals(objetoParcelamento, parcelamento);
	}

	@Test(expected = QuantidadeDeParcelasComValorInvalidoException.class)
	public void testaParcelamentoComQuantidadeDeParcelasInvalida() {
		new Parcelador().realizaParcelamento(100, -3, "07/01/2020", 30);
	}

	@Test(expected = ValorTotalAParcelarComValorInvalidoException.class)
	public void testaParcelamentoComValorTotalAParcelarInvalido() {
		new Parcelador().realizaParcelamento(-100, 3, "07/01/2020", 30);
	}

	@Test(expected = ValorTotalAParcelarComValorInvalidoException.class)
	public void testaParcelamentoComValorTotalAParcelarComNumeroCasasDecimaisInvalido() {
		new Parcelador().realizaParcelamento(100.001, 3, "07/01/2020", 30);
	}

	private void imprimeParcelamento(List<Parcela> parcelamento) {
		parcelamento.forEach(parcela -> {
			StringBuilder informações = new StringBuilder()
					.append("Parcela: ")
					.append(parcela.getNumeroDaParcela())
					.append(", Valor: ")
					.append(parcela.getDataDeVencimento())
					.append(", Vencimento: ")
					.append(parcela.getValorDaParcela());
//			System.out.println("Parcela: " + parcela.getNumeroDaParcela() + ", Vencimento: "
//					+ parcela.getDataDeVencimento() + ", Valor: " + parcela.getValorDaParcela());
			System.out.println(informações.toString());
		});
	}

}
