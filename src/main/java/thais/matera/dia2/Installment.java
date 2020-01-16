package thais.matera.dia2;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Installment {
	private int Id;
	private BigDecimal Value;
	private LocalDate DueData;
	
	public Installment(int Id, BigDecimal Value, LocalDate DueDate) {
		this.setId(Id);
		this.setValue(Value);
		this.setDueData(DueDate);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DueData == null) ? 0 : DueData.hashCode());
		result = prime * result + Id;
		result = prime * result + ((Value == null) ? 0 : Value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Installment other = (Installment) obj;
		if (DueData == null) {
			if (other.DueData != null)
				return false;
		} else if (!DueData.equals(other.DueData))
			return false;
		if (Id != other.Id)
			return false;
		if (Value == null) {
			if (other.Value != null)
				return false;
		} else if (!Value.equals(other.Value))
			return false;
		return true;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public BigDecimal getValue() {
		return Value;
	}

	public void setValue(BigDecimal value) {
		Value = value;
	}

	public LocalDate getDueData() {
		return DueData;
	}

	public void setDueData(LocalDate dueData) {
		DueData = dueData;
	}
}
