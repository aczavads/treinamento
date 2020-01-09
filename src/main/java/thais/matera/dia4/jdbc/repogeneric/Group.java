package thais.matera.dia4.jdbc.repogeneric;

import java.time.LocalDate;

public class Group extends Entity {
	private String description;
	private LocalDate foundationDate;
	
	public Group(String description, LocalDate foundationDate) {
		super();
		this.description = description;
		this.foundationDate = foundationDate;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public LocalDate getFoundationDate() {
		return foundationDate;
	}
	
	public void setFoundationDate(LocalDate foundatonDate) {
		this.foundationDate = foundatonDate;
	}
}
