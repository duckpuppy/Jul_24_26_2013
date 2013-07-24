package com.aci.lab02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	private AccountDao accountDao;
	private StatementDao statementDao;
	
	@Autowired
	@Qualifier("accountdao")
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	@Autowired
	@Qualifier("statementdao")
	public void setStatementDao(StatementDao statementDao) {
		this.statementDao = statementDao;
	}
	public void deposit(int accountNumber,String type, int amount) {
		accountDao.deposit(accountNumber, amount);
		statementDao.addStatement(accountNumber, type, amount);
	}
	public void withdraw(int accountNumber,String type, int amount)
	{
		accountDao.withdraw(accountNumber, amount);
		statementDao.addStatement(accountNumber, type, amount);
	}
}
