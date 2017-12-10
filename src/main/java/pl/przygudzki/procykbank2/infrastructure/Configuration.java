package pl.przygudzki.procykbank2.infrastructure;

import org.springframework.context.annotation.Bean;
import pl.przygudzki.procykbank2.application.AccountsManager;
import pl.przygudzki.procykbank2.application.TransactionsRegistrar;
import pl.przygudzki.procykbank2.application.implementation.StandardAccountsManager;
import pl.przygudzki.procykbank2.application.implementation.StandardTransactionRegistrar;
import pl.przygudzki.procykbank2.model.TransactionsFactory;
import pl.przygudzki.procykbank2.model.TransactionsRepository;

@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean
	public TransactionsRepository transactionsRepository() {
		return new JPATransactionRepository();
	}

	@Bean
	public TransactionsRegistrar transactionsRegistrar(TransactionsRepository transactionsRepository) {
		TransactionsFactory factory = new TransactionsFactory();
		return new StandardTransactionRegistrar(factory, transactionsRepository);
	}

	@Bean
	public AccountsManager accountsManager() {
		return new StandardAccountsManager();
	}

}
