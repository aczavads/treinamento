package thais.matera.dia2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppCollections {	
	public static void main(String[] args) {		
		BigDecimal value = BigDecimal.valueOf(Double.parseDouble(args[0]));
		int installments = Integer.parseInt(args[1]);
		final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate baseData = LocalDate.parse(args[2], dateTimeFormatter);
		int days = Integer.parseInt(args[3]);
		
		List<Installment> installmentList = (List<Installment>) initInstallmentList(value, installments, baseData, days); 
		
		for (Installment installment : installmentList) {
			System.out.println("+++++++++++++++++++++++");
			System.out.println("Parcela: " + installment.getId());
			System.out.println("Valor: " + installment.getValue());
			System.out.println("Data de Vencimento: " + installment.getDueData());
			System.out.println("+++++++++++++++++++++++");
		}
	}
	
	public static Collection<Installment> initInstallmentList(BigDecimal value, int installments, LocalDate BaseData, int days) {
		verifyInput(value, installments, BaseData, days);
		
		List<Installment> installmentList = new ArrayList();
		
		BigDecimal installmentValue = value.divide(new BigDecimal(installments), 2, RoundingMode.FLOOR);
		BigDecimal rest = value.subtract(installmentValue.multiply(new BigDecimal(installments)));
		
		installmentList.add(new Installment(1, installmentValue.add(rest), BaseData.plusDays(days)));

		for(int i = 1; i < installments; i++) {
			installmentList.add(new Installment(i+1, installmentValue, BaseData.plusDays(days*(i+1))));
		}
		
		return installmentList;
	}
	
	public static void verifyInput(BigDecimal value, int installments, LocalDate BaseData, int days) {
		if(value.scale() != 2) {
			throw new ValueException("value is invalid");
		}
		
		if(installments <= 0) {
			throw new InstallmentException("installments value is less than 0");
		}
		
		if(value.compareTo(BigDecimal.ZERO) < 0) {
			throw new ValueException("value is less than 0");
		}
	}
}
