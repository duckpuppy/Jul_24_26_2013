package com.aci;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class AccountService {
	@Autowired
	TransactionTemplate transactionTemplate;

	@Autowired
	private AccountDao accountDao;

	@Autowired
	private StatementDao statementDao;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void deposit(int accountNumber, String type, int amount) {
		accountDao.deposit(accountNumber, amount);
		statementDao.addStatement(accountNumber, type, amount);
	}

	public void withdraw(final int accountNumber, final String type,
			final int amount) {
		int propagation = transactionTemplate.getPropagationBehavior();
		transactionTemplate
				.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);

		try {
			transactionTemplate.execute(new TransactionCallbackWithoutResult() {

				@Override
				protected void doInTransactionWithoutResult(
						TransactionStatus arg0) {
					accountDao.withdraw(accountNumber, amount);
					statementDao.addStatement(accountNumber, type, -amount);

					// Force the transaction to fail, causing a roll back
					throw new ArrayIndexOutOfBoundsException();
				}
			});
		} finally {
			transactionTemplate.setPropagationBehavior(propagation);
		}
	}

	public int getBalance(int accountNumber) {
		return accountDao.getBalance(accountNumber);
	}
}
