package pl.przygudzki.procykbank2.model;

public class TransactionsFactory {

	public Transaction createTransaction(RegisterTransactionCommand command) {
		return new Transaction();
	}

}
