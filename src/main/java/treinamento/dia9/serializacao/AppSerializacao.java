package treinamento.dia9.serializacao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AppSerializacao {
	private static final String CAMINHO_DO_ARQUIVO_SERIALIZADO = "c:/treinamento/placar.serializado";

	public static void main(String[] args) {
		//Placar p = new Placar(900);
		
		//persistirPlacar(p);
		
		Placar recuperado = recuperarPlacar();
		System.out.println("Placar recuperado: " + recuperado.getPontuacao());
		System.out.println("Foi.");
	}

	private static Placar recuperarPlacar() {
		try (ObjectInputStream out = new ObjectInputStream(
				new FileInputStream(CAMINHO_DO_ARQUIVO_SERIALIZADO))){
			return (Placar) out.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}

	private static void persistirPlacar(Placar p) {
		try (ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream(CAMINHO_DO_ARQUIVO_SERIALIZADO))){
			out.writeObject(p);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
