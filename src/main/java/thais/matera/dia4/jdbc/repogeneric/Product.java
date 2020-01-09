package thais.matera.dia4.jdbc.repogeneric;

public class Product extends Entity {
	private String name;
	
	public Product(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
