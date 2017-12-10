package pl.przygudzki.procykbank2.infrastructure;

import org.springframework.context.annotation.Bean;
import pl.przygudzki.procykbank2.application.AccountsManager;
import pl.przygudzki.procykbank2.application.TransactionsRegistrar;
import pl.przygudzki.procykbank2.application.implementation.StandardAccountsManager;
import pl.przygudzki.procykbank2.application.implementation.StandardTransactionRegistrar;

@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean
	public TransactionsRegistrar transactionsRegistrar() {
		return new StandardTransactionRegistrar();
	}

	@Bean
	public AccountsManager accountsManager() {
		return new StandardAccountsManager();
	}

}
