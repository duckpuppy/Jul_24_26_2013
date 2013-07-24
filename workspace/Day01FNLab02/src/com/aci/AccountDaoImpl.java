package com.aci;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl extends BaseDaoSupport implements AccountDao {
	private static final String balanceQuery = "select balance from accounts where account_number = ?";
	@Override
	public void deposit(int accountNumber, int amount) {
		int balance = getBalance(accountNumber);
		balance += amount;
		updateBalance(accountNumber, balance);
	}

	@Override
	public void withdraw(int accountNumber, int amount) {
		deposit(accountNumber, -amount);
	}
	
	public int getBalance(int accountNumber) {
		return getJdbcTemplate().queryForObject(balanceQuery, Integer.class, accountNumber);
	}

	private void updateBalance(int accountNumber, int amount) {
		String query = "update accounts set balance=? where account_number=?";
		getJdbcTemplate().update(query, amount, accountNumber);
	}
}
