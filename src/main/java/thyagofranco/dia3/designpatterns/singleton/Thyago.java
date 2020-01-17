package thyagofranco.dia3.designpatterns.singleton;

public class Thyago {
	
	private static final Thyago thyagofranco = new Thyago();
	
	private Thyago() {}
	
	public static Thyago getInstance() {
		return thyagofranco;
	}
	

}
