package treinamento.diegomucheniski.dia7;

public class AppFormatando {

	public static void main(String[] args) {
		
		String codigoPai = "1.01.01";
		String codigoFilho = "1.01.01.0010000000000000";
		
		System.out.println("Tamanho do c�digo pai: " + codigoPai.length());
		System.out.println("Tamanho do c�digo Filho: " + codigoFilho.length());
		
		
		String codigoComparado = codigoFilho.substring(0, codigoPai.length());
		System.out.println("Codigo Comparado: " + codigoComparado);
		
		if (codigoComparado.equals(codigoPai)) {
			System.out.println("� igual");
		}
		else {
			System.out.println("N�o � igual");
		}
		
		System.out.println("� ponto??? " + codigoFilho.substring(codigoPai.length(), codigoPai.length()+1));
		
	}
	
}
