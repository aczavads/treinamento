package treinamento.thyagofranco.dia7.conta_contabil.utils.formatando;

import java.util.StringTokenizer;

public class AppFormatando {

	public static void main(String[] args) {
		String codigo = "1.01.01.001";
		StringTokenizer tokenizer = new StringTokenizer(codigo,".");
		while(tokenizer.hasMoreElements()) {
			System.out.println(tokenizer.nextElement());
		}
		System.out.println(String.format("%03d", 9));
		
		
		String codigoPai = "1.01.01";
		String codigoFilho = "1.01.02.01";
		
		System.out.println("Tamanho do c�digo pai: " + codigoPai.length());
		System.out.println("Tamanho do c�digo filho: " + codigoFilho.length());
		
		String codigoComparado = codigoFilho.substring(0, codigoPai.length());
		System.out.println("Codigo Comparado: " + codigoComparado);
		
		if (codigoComparado.equals(codigoPai)) {
			System.out.println("� igual");
		}
		else {
			System.out.println("N�o � igual");
		}
		
		
		String codigoDoSuperior = "1.01.01";
		String codigoDoFilho = "1.01.01.001";
		
		System.out.println(ehFilhoValido(codigoDoSuperior, codigoDoFilho));
		
		
	}

	private static boolean ehFilhoValido(String codigoDoSuperior, String codigoDoFilho) {
		int tamanhoSuperior = codigoDoSuperior.trim().length();
		String prefixo = codigoDoFilho.trim().substring(0, tamanhoSuperior);
		System.out.println("C�digo da superior: " + codigoDoSuperior);
		System.out.println("C�digo da filha: " + codigoDoFilho);
		System.out.println(prefixo);
		System.out.println("Segue ponto ?...." + codigoDoFilho.substring(tamanhoSuperior, tamanhoSuperior+1).equals("."));
		System.out.println("final � n�mero?..." + codigoDoFilho.substring(tamanhoSuperior, codigoDoFilho.length()));
		
		codigoDoFilho.substring(tamanhoSuperior, tamanhoSuperior+1).equals(".");
		return prefixo.equals(codigoDoSuperior);
	}
}
