package pl.przygudzki.procykbank2.application.implementation;

import pl.przygudzki.procykbank2.application.TransactionsRegistrar;
import pl.przygudzki.procykbank2.model.RegisterTransactionCommand;
import pl.przygudzki.procykbank2.model.Transaction;
import pl.przygudzki.procykbank2.model.TransactionsFactory;
import pl.przygudzki.procykbank2.model.TransactionsRepository;

import javax.transaction.Transactional;

public class StandardTransactionRegistrar implements TransactionsRegistrar {

	private final TransactionsFactory factory;
	private final TransactionsRepository repository;

	public StandardTransactionRegistrar(TransactionsFactory factory, TransactionsRepository repository) {
		this.factory = factory;
		this.repository = repository;
	}

	@Transactional
	@Override
	public void registerTransaction(RegisterTransactionCommand command) {
		Transaction transaction = factory.createTransaction(command);
		repository.put(transaction);
	}

}
