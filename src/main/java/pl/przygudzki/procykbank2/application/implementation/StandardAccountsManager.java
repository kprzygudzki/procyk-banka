package pl.przygudzki.procykbank2.application.implementation;

import pl.przygudzki.procykbank2.application.AccountsManager;
import pl.przygudzki.procykbank2.application.BalanceDto;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class StandardAccountsManager implements AccountsManager {

	private static Map<String, BigDecimal> accounts = getAccounts();

	@Override
	public BalanceDto getBalance(String accountId) {
		BalanceDto balanceDto = new BalanceDto();
		balanceDto.setBalance(accounts.get(accountId));
		return balanceDto;
	}

	private static HashMap<String, BigDecimal> getAccounts() {
		HashMap<String, BigDecimal> accounts = new HashMap<>();
		accounts.put("zaargh", BigDecimal.valueOf(-15.0));
		accounts.put("psotnick", BigDecimal.valueOf(15.0));
		return accounts;
	}

}
