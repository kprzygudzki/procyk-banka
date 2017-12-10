package pl.przygudzki.procykbank2.ui;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.przygudzki.procykbank2.application.TransactionsRegistrar;
import pl.przygudzki.procykbank2.model.RegisterTransactionCommand;

@RestController
class TransactionsController {

	private final TransactionsRegistrar registrar;

	TransactionsController(TransactionsRegistrar registrar) {
		this.registrar = registrar;
	}

	@PostMapping("/transactions")
	void registerTransaction(RegisterTransactionCommand command) {
		registrar.registerTransaction(command);
	}

}
