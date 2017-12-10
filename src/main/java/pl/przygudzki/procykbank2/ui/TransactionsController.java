package pl.przygudzki.procykbank2.ui;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.przygudzki.procykbank2.application.TransactionsRegistrar;
import pl.przygudzki.procykbank2.model.RegisterTransactionCommand;

import java.math.BigDecimal;

@RestController
class TransactionsController {

	private final TransactionsRegistrar registrar;

	TransactionsController(TransactionsRegistrar registrar) {
		this.registrar = registrar;
	}

	@PostMapping("/transactions")
	void registerTransaction(@RequestParam String who, @RequestParam BigDecimal amount) {
		RegisterTransactionCommand command = new RegisterTransactionCommand();
		command.setWho(who);
		command.setAmount(amount);
		registrar.registerTransaction(command);
	}

}
