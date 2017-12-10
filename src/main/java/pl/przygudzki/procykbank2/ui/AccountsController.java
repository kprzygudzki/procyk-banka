package pl.przygudzki.procykbank2.ui;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.przygudzki.procykbank2.application.AccountsManager;
import pl.przygudzki.procykbank2.application.BalanceDto;

import java.math.BigDecimal;

@RestController
class AccountsController {

	private AccountsManager accountsManager;

	AccountsController(AccountsManager accountsManager) {
		this.accountsManager = accountsManager;
	}

	@GetMapping("/account/{accountId}")
	BalanceDto queryBalance(@PathVariable String accountId) {
		return accountsManager.getBalance(accountId);
	}

}
