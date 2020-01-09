package treinamento.dia3.factory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

public class RegistradorFactory {

	public static RegistradorDeTransacoes createInstance(String tipo) {
		if (tipo.equalsIgnoreCase("log")) {
			return new RegistradorDeTransacoesPorLog();
		} else if (tipo.equalsIgnoreCase("popup")) {			
			return new RegistradorDeTransacoesPorPopup();
		}
		return null;
	}

	public static RegistradorDeTransacoes createInstance() {
		/*
		InputStream input = null;
		try {
			input = RegistradorDeTransacoes.class.getResourceAsStream("app.properties");
			Properties propriedades = new Properties();
			propriedades.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		*/
		try (InputStream input = RegistradorDeTransacoes.class
				.getResourceAsStream("app.properties");) {
			
			Properties propriedades = new Properties();
			propriedades.load(input);
			String nomeDaClasse = propriedades.getProperty("tipoDoRegistrador");
			Class<RegistradorDeTransacoes> classeDoRegistrador = 
					(Class<RegistradorDeTransacoes>)Class.forName(nomeDaClasse);
			
			//Constructor c = classeDoRegistrador.getConstructor(new Class[] {Boolean.class, String.class});
			//c.newInstance(new Object[] {true, "Teste"});
			
			return classeDoRegistrador.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
