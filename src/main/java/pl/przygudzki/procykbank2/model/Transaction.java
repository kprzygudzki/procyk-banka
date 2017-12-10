package pl.przygudzki.procykbank2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Transaction {

	@Id
	@GeneratedValue
	private Long id;

	private final String who;
	private final BigDecimal amount;

	private Transaction(String who, BigDecimal amount) {

		this.who = who;
		this.amount = amount;
	}

	static Transaction create(RegisterTransactionCommand command) {
		String who = command.getWho();
		BigDecimal amount = command.getAmount();
		return new Transaction(who, amount);
	}

}
