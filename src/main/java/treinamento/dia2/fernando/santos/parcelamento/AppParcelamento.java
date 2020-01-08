package treinamento.dia2.fernando.santos.parcelamento;

public class AppParcelamento {

	public static void main(String[] args) {
		Parcelador parcelador = new Parcelador();
		
//		List<Parcela> parcelamento = parcelador.realizaParcelamento(100, 3, "07/01/2020", 30);
//		
//		parcelamento.forEach(parcela -> {
//			System.out.print("Parcela: " + parcela.getNumeroDaParcela());
//			System.out.print(", Vencimento: " + parcela.getDataDeVencimento());
//			System.out.println(", Valor: " + parcela.getValorDaParcela());
//		});
		
		Double valorTotal = Double.valueOf(args[0]);
		Integer quantidadeDeParcelas = Integer.valueOf(args[1]);
		String dataBase = args[2];
		Integer prazoEmDias = Integer.valueOf(args[3]);
		
		parcelador.realizaParcelamento(valorTotal, quantidadeDeParcelas, dataBase, prazoEmDias);

	}

}
