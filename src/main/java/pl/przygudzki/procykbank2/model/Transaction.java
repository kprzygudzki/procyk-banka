package pl.przygudzki.procykbank2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Transaction {

	@Id
	@GeneratedValue
	Long id;

}
