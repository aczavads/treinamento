package treinamento.dia6.exercicio.veiculo.fernando.santos;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class MotorFactory {

	public static Motor getInstance() {
		String propertyMotor;

		try (InputStream propertiesFile = new FileInputStream("src/main/resources/AppVeiculo.properties")) {
			Properties properties = new Properties();
			properties.load(propertiesFile);

			propertyMotor = properties.getProperty("motor");

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		if ("motoreletrico".equals(propertyMotor)) {
			return new MotorEletrico();
		} else if ("motorv6".equals(propertyMotor)) {
			return new MotorV6();
		} else if ("motorv8".equals(propertyMotor)) {
			return new MotorV8();
		}
		throw new MotorInexistenteException();

	}

}
