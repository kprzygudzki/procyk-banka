package pl.przygudzki.procykbank2.infrastructure;

import pl.przygudzki.procykbank2.model.Transaction;
import pl.przygudzki.procykbank2.model.TransactionsRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

class JPATransactionRepository implements TransactionsRepository {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void put(Transaction transaction) {
		entityManager.persist(transaction);
	}

}
