package schiavon.gabriel.dia7.movimentoContaContabil;

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
