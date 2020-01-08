package giovani.bueno.factory;

import javax.swing.JOptionPane;

public class Grafico  implements SuperLogger{

	@Override
	public void log(String message) {
		JOptionPane.showMessageDialog(null,message);
		
	}

}
