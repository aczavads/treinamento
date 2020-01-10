package thais.matera.dia5.jpa;

import java.util.InputMismatchException;

import javax.persistence.Embeddable;

@Embeddable
public class CPF {
	private final String valor;
	
	public CPF() {
		this.valor = "00000000000";
	}
	
	public CPF(String valor) {
		if(!validar(valor)) {
			throw new RuntimeException("O numero nao eh um cpf valido!");
		}
		this.valor = valor;
	}
	
	private boolean validar(String valor) {
		valor = valor.replaceAll("\\.", "").replaceAll("-", "");
		if (valor.equals("00000000000") || valor.equals("11111111111") ||
			valor.equals("22222222222") || valor.equals("33333333333") ||
			valor.equals("44444444444") || valor.equals("55555555555") ||
			valor.equals("66666666666") || valor.equals("77777777777") ||
			valor.equals("88888888888") || valor.equals("99999999999") ||
	        (valor.length() != 11)) {
			
			return false;
		}
		
		char dig10, dig11;
		int sm, i, r, num, peso;
  
		try {
			sm = 0;
			peso = 10;
			for (i=0; i<9; i++) {              
				num = (int)(valor.charAt(i) - 48); 
				sm = sm + (num * peso);
				peso = peso - 1;
			}
			
			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

			sm = 0;
			peso = 11;
			for(i=0; i<10; i++) {
				num = (int)(valor.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else dig11 = (char)(r + 48);
          
			if ((dig10 == valor.charAt(9)) && (dig11 == valor.charAt(10)))
				return(true);
			else return(false);
		} catch (InputMismatchException erro) {
			return(false);
		}
		
	}

	public String getNumero() {
		return valor;
	}

}
