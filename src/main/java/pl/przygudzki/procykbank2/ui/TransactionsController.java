package pl.przygudzki.procykbank2.ui;

import pl.przygudzki.procykbank2.api.TransactionsRegistrar;

public class TransactionsController {

	private final TransactionsRegistrar registrar;

	public TransactionsController(TransactionsRegistrar registrar) {
		this.registrar = registrar;
	}

	void registerTransaction() {
		registrar.registerTransaction();
	}

}
