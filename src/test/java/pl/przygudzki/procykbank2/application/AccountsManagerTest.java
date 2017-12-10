package pl.przygudzki.procykbank2.application;

import org.junit.Before;
import org.junit.Test;
import pl.przygudzki.procykbank2.application.AccountsManager;
import pl.przygudzki.procykbank2.application.BalanceDto;
import pl.przygudzki.procykbank2.infrastructure.Configuration;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountsManagerTest {

	private AccountsManager manager;

	@Before
	public void setUp() throws Exception {
		manager = new Configuration().accountsManager();
	}

	@Test
	public void whenQueryingZaarghsBalanceReturnsAnAccountBalanceDto() {
		BalanceDto balanceDto = manager.getBalance("zaargh");
		assertThat(balanceDto.getBalance()).isEqualTo(BigDecimal.valueOf(-15.0));
	}

	@Test
	public void whenQueryingPsotnicksBalanceReturnsAnAccountBalanceDto() {
		BalanceDto balanceDto = manager.getBalance("psotnick");
		assertThat(balanceDto.getBalance()).isEqualTo(BigDecimal.valueOf(15.0));
	}

}
