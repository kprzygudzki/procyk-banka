package pl.przygudzki.procykbank2.ui;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.przygudzki.procykbank2.application.BalanceDto;

import java.math.BigDecimal;

@RestController
public class AccountsController {

	@GetMapping("/account/zaargh")
	public BalanceDto queryBalance(String account_id) {
		BalanceDto balanceDto = new BalanceDto();
		balanceDto.setBalance(BigDecimal.valueOf(-15.0));
		return balanceDto;
	}

}
