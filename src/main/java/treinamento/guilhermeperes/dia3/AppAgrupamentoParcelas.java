package treinamento.guilhermeperes.dia3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import treinamento.dia2.NumeroDeParcelasInvalido;
import treinamento.dia2.ValorAParcelarInvalido;

public class AppAgrupamentoParcelas {
	public static void main(String[] args) {
		List<Parcela> listaDeParcelas = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			listaDeParcelas.addAll(parcelar(new BigDecimal("1000.00"), 10, LocalDate.of(2020, 1, 8), 30));
		}
		
		Map<LocalDate, List<Parcela>> mapaDeParcelas = agrupar(listaDeParcelas);
		
		mapaDeParcelas.forEach((chave, lista) -> {
			System.out.println("Dia: " + chave);
			System.out.println(lista.size());
			
			lista.stream().forEach(System.out::println);
		});
	}
	
	public static List<Parcela> parcelar(BigDecimal valor, int quantidadeDeParcelas, LocalDate dataBase, int prazoEmDias) {
		validarValorAParcelar(valor);
		validarQuantidadeDeParcelas(quantidadeDeParcelas);

		List<Parcela> parcelas = new ArrayList<Parcela>();
		
		BigDecimal valorDaParcela = valor.divide(new BigDecimal(quantidadeDeParcelas), 2, RoundingMode.FLOOR);
		
		BigDecimal resto = valor
				.subtract(valorDaParcela.multiply(new BigDecimal(quantidadeDeParcelas)));
		
		parcelas.add(new Parcela(1, dataBase.plusDays(prazoEmDias), valorDaParcela.add(resto)));
		
		for (int parcela = 1; parcela < quantidadeDeParcelas; parcela++) {
			parcelas.add(new Parcela(parcela+1, dataBase.plusDays((parcela + 1) * prazoEmDias), valorDaParcela));
		}
		
		return parcelas;
	}

	private static void validarQuantidadeDeParcelas(int quantidadeDeParcelas) {
		if (quantidadeDeParcelas <= 0) {
			throw new NumeroDeParcelasInvalido("O número de parcelas deve ser maior que zero!");
		}
	}

	private static void validarValorAParcelar(BigDecimal valor) {
		if (valor.scale() != 2) {
			throw new ValorAParcelarInvalido("O valor deve ter duas casas decimais!");
		}
		if (valor.compareTo(BigDecimal.ZERO) <= 0) {
			throw new ValorAParcelarInvalido("O valor deve ser maior que zero!");
		}
	}
	
	public static Map<LocalDate, List<Parcela>> agrupar(List<Parcela> parcelas) {
		Map<LocalDate, List<Parcela>> mapa = new HashMap<>();
		
		parcelas.stream().forEach(parcela -> {
			if (!mapa.containsKey(parcela.getDataVencimento())) {
				mapa.put(parcela.getDataVencimento(), new ArrayList<Parcela>());
			}
			
			mapa.get(parcela.getDataVencimento()).add(parcela);
		});
		
		return mapa;
	}
}
