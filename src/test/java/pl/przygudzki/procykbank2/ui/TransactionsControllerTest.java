package pl.przygudzki.procykbank2.ui;

import org.junit.Test;
import org.mockito.Mockito;
import pl.przygudzki.procykbank2.application.TransactionsRegistrar;
import pl.przygudzki.procykbank2.model.RegisterTransactionCommand;

public class TransactionsControllerTest {

	@Test
	public void whenRegisteringTransactionShouldCallOnTransactionsRegistrar() {
		TransactionsRegistrar registrar = Mockito.mock(TransactionsRegistrar.class);
		TransactionsController controller = new TransactionsController(registrar);
		RegisterTransactionCommand command = new RegisterTransactionCommand();
		controller.registerTransaction(command);



		Mockito.verify(registrar).registerTransaction();
	}

	@Test
	public void whenRegisteringTransaction() {
	}

}
