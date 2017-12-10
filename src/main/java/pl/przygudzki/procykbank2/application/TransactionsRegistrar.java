package pl.przygudzki.procykbank2.application;

import pl.przygudzki.procykbank2.model.RegisterTransactionCommand;

public interface TransactionsRegistrar {

	void registerTransaction(RegisterTransactionCommand command);

}
