package giovani.bueno.autoCloseable;

public class AppAutoCloseable {

	public static void main(String[] args) {
		try (Porta p = new Porta()) {

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
