package pl.przygudzki.procykbank2.infrastructure;

import pl.przygudzki.procykbank2.application.TransactionsRegistrar;
import pl.przygudzki.procykbank2.application.implementation.StandardTransactionRegistrar;
import pl.przygudzki.procykbank2.model.TransactionsFactory;
import pl.przygudzki.procykbank2.model.TransactionsRepository;

public class TestConfiguration {

	public TransactionsRegistrar transactionsRegistrar(TransactionsFactory factory) {
		TransactionsRepository repository = new InMemoryTransactionRepository();
		return new StandardTransactionRegistrar(factory, repository);
	}

}
