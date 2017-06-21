package pl.przygudzki.procykbank2.infrastructure;

import org.springframework.context.annotation.Bean;
import pl.przygudzki.procykbank2.api.TransactionsRegistrar;
import pl.przygudzki.procykbank2.api.implementation.StandardTransactionRegistrar;

@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean
	TransactionsRegistrar transactionsRegistrar() {
		return new StandardTransactionRegistrar();
	}

}
