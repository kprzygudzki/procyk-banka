package pl.przygudzki.procykbank2.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TransactionsFactoryTest {

	private static final String WHO = "psotnick";
	private static final BigDecimal AMOUNT = BigDecimal.valueOf(12.34);
	private TransactionsFactory factory = new TransactionsFactory();

	@Test
	public void shouldCreateTransaction() {
		RegisterTransactionCommand command = new RegisterTransactionCommand();
		command.setWho(WHO);
		command.setAmount(AMOUNT);

		Transaction transaction = factory.createTransaction(command);

		Assertions.assertThat(transaction)
				.hasFieldOrPropertyWithValue("who", WHO)
				.hasFieldOrPropertyWithValue("amount", AMOUNT);
	}

}
