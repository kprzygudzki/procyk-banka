package pl.przygudzki.procykbank2.ui;

import org.junit.Test;
import org.mockito.Mockito;
import pl.przygudzki.procykbank2.api.TransactionsRegistrar;

public class TransactionsControllerTest {

	@Test
	public void whenRegisteringTransactionShouldCallOnTransactionsRegister() {
		TransactionsRegistrar registrar = Mockito.mock(TransactionsRegistrar.class);
		TransactionsController controller = new TransactionsController(registrar);
		controller.registerTransaction();
		Mockito.verify(registrar).registerTransaction();
	}

}
