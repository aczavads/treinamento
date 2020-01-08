package GLF.dia3;

public class Singleton {
	
	private static final Singleton singleton = new Singleton();
	
		private Singleton() {
			
		}
		
		public static Singleton getInstance(){
			return singleton;
			
		}
		
		public void abrir() {
			System.out.println("Abrindo");
		}
	}

