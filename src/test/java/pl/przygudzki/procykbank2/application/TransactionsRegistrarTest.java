package pl.przygudzki.procykbank2.application;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import pl.przygudzki.procykbank2.application.implementation.StandardTransactionRegistrar;
import pl.przygudzki.procykbank2.infrastructure.TestConfiguration;
import pl.przygudzki.procykbank2.model.RegisterTransactionCommand;
import pl.przygudzki.procykbank2.model.Transaction;
import pl.przygudzki.procykbank2.model.TransactionsFactory;
import pl.przygudzki.procykbank2.model.TransactionsRepository;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TransactionsRegistrarTest {

	@Mock private TransactionsFactory factory;
	@Mock private TransactionsRepository repository;

	private TransactionsRegistrar registrar;
	private Transaction transaction;

	@Before
	public void setUp() throws Exception {
		registrar = new StandardTransactionRegistrar(factory, repository);
		transaction = new Transaction();
	}

	@Test
	public void shouldRegisterTransactionForZaargh() {
		RegisterTransactionCommand command = new RegisterTransactionCommand();
		Mockito.when(factory.createTransaction(command)).thenReturn(transaction);

		registrar.registerTransaction(command);

		verify(factory).createTransaction(command);
		verify(repository).put(transaction);
	}

}
