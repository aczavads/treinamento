package treinamento.dia4.auto_closeable;

public class App {
	
	public static void main(String[] args) {
		
		try (Porta p = new Porta()) { 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Porta p = null;
		try {
			p = new Porta();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (p != null) {
				try {
					p.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
