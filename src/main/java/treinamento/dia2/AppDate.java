package treinamento.dia2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class AppDate {

	public static void main(String[] args) {
		LocalDate natal = LocalDate.of(2019, 12, 25);
		System.out.println(natal + " + 20 dias = " + natal.plusDays(20));	
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data = LocalDate.parse("12/03/1988", formatador);
		System.out.println(data);
		
		
		SimpleDateFormat formatador2 = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date data2 = formatador2.parse("12/03/1988");
			System.out.println(data2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	
	}
}
