package pl.przygudzki.procykbank2.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
class TransactionId implements Serializable {

	private Long id;

}
