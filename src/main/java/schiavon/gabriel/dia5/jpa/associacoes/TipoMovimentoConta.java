package schiavon.gabriel.dia5.jpa.associacoes;

public enum TipoMovimentoConta {

	DEBITO,
	CREDITO;
	
	public boolean isDebito() {
		return DEBITO.equals(this);
	}
	
	public boolean isCredito() {
		return CREDITO.equals(this);
	}
}
