package com.aci.lab04;

import org.springframework.stereotype.Repository;

@Repository("accountdao")
public class AccountDaoImpl extends BaseDaoSupport implements AccountDao{
	
	public void deposit(int accountNumber,int amount)
	{
	    String query = "update accounts set balance=balance+? where account_number=?";
	    super.getJdbcTemplate().update(query,amount,accountNumber);
	}
	public void withdraw(int accountNumber,int amount)
	{
	    String query = "update accounts set balance=balance-? where account_number=?";
	    super.getJdbcTemplate().update(query,amount,accountNumber);
	}
}
