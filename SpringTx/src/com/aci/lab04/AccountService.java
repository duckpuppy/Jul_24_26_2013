package com.aci.lab04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class AccountService {
	private AccountDao accountDao;
	private StatementDao statementDao;
	private TransactionTemplate transactionTemplate;

	@Autowired
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	@Autowired
	@Qualifier("accountdao")
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	@Autowired
	public void setStatementDao(StatementDao statementDao) {
		this.statementDao = statementDao;
	}
	@Transactional
	public void deposit(int accountNumber,String type, int amount) {
		accountDao.deposit(accountNumber, amount);
		statementDao.addStatement(accountNumber, type, amount);
	}
	public void withdraw(final int accountNumber,final String type, final int amount)
	{
		transactionTemplate.execute(new TransactionCallback<Object>() {
			public Object doInTransaction(TransactionStatus transactionStatus) {
				try{
					accountDao.withdraw(accountNumber, amount);
					statementDao.addStatement(accountNumber, type, amount);
				}
				catch(Exception ex){
					System.out.println("Error : " + ex.getMessage());
					transactionStatus.setRollbackOnly();
				}
				return null;
			}
		});

	}
}
