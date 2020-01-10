package treinamento.dia4.auto_closeable;

public class Porta implements AutoCloseable {

	@Override
	public void close() throws Exception {
		System.out.println("Bam!");
	}

}
