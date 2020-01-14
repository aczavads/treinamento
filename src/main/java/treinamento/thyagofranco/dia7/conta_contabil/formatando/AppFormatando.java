package treinamento.thyagofranco.dia7.conta_contabil.formatando;

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
		
		System.out.println("Tamanho do código pai: " + codigoPai.length());
		System.out.println("Tamanho do código filho: " + codigoFilho.length());
		
		String codigoComparado = codigoFilho.substring(0, codigoPai.length());
		System.out.println("Codigo Comparado: " + codigoComparado);
		
		if (codigoComparado.equals(codigoPai)) {
			System.out.println("É igual");
		}
		else {
			System.out.println("Não é igual");
		}
		
		
		String codigoDoSuperior = "1.01.01";
		String codigoDoFilho = "1.01.01.001";
		
		System.out.println(ehFilhoValido(codigoDoSuperior, codigoDoFilho));
		
		
	}

	private static boolean ehFilhoValido(String codigoDoSuperior, String codigoDoFilho) {
		int tamanhoSuperior = codigoDoSuperior.trim().length();
		String prefixo = codigoDoFilho.trim().substring(0, tamanhoSuperior);
		System.out.println("Código da superior: " + codigoDoSuperior);
		System.out.println("Código da filha: " + codigoDoFilho);
		System.out.println(prefixo);
		System.out.println("Segue ponto ?...." + codigoDoFilho.substring(tamanhoSuperior, tamanhoSuperior+1).equals("."));
		System.out.println("final é número?..." + codigoDoFilho.substring(tamanhoSuperior, codigoDoFilho.length()));
		
		codigoDoFilho.substring(tamanhoSuperior, tamanhoSuperior+1).equals(".");
		return prefixo.equals(codigoDoSuperior);
	}
}
