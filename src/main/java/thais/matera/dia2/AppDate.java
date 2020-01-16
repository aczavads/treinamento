package thais.matera.dia2;

import java.time.LocalDate;

public class AppDate {
	public static void main(String args) {
		LocalDate christmas = LocalDate.of(2018, 12, 25);
		christmas = christmas.plusDays(20);
		System.out.println(christmas);
	}
}
