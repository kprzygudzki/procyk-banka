package pl.przygudzki.procykbank2.ui;

import org.junit.Before;
import org.junit.Test;
import pl.przygudzki.procykbank2.api.BalanceDto;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountsControllerTest {

	private AccountsController controller;

	@Before
	public void setUp() throws Exception {
		controller = new AccountsController();
	}

	@Test
	public void whenQueryingZaarghsBalanceReturnsAnAccountBalanceDto() {
		BalanceDto balanceDto = controller.queryBalance("zaargh");
		assertThat(balanceDto.getBalance()).isEqualTo(BigDecimal.valueOf(-15.0));
	}

	@Test
	public void whenQueryingPsotnicksBalanceReturnsAnAccountBalanceDto() {
		BalanceDto balanceDto = controller.queryBalance("psotnick");
		assertThat(balanceDto.getBalance()).isEqualTo(BigDecimal.valueOf(15.0));
	}
}
