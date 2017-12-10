package pl.przygudzki.procykbank2.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RegisterTransactionCommand {

	private String who;
	private BigDecimal amount;

}
