package treinamento.dia7.formatando;

import java.util.StringTokenizer;

public class AppFormatando {
	
	public static void main(String[] args) {
		String codigoDaSuperior = "1.01.01";
		
		String codigo = "1.01.01.001";
		
		System.out.println(ehFilhoValido(codigoDaSuperior, codigo));
	}

	private static boolean ehFilhoValido(String codigoDaSuperior, String codigo) {
		int tamanhoSuperior = codigoDaSuperior.trim().length();
		String prefixo = codigo.trim().substring(0, tamanhoSuperior);
		System.out.println("Código da superior: " + codigoDaSuperior);
		System.out.println("Código da filha...: " + codigo);
		System.out.println(prefixo);
		System.out.println("Segue ponto?......: " + codigo.substring(tamanhoSuperior,tamanhoSuperior+1).equals("."));
		System.out.println("Final é número?...: " + codigo.substring(tamanhoSuperior+1, codigo.length()));
		return prefixo.equals(codigoDaSuperior);
	}

}
