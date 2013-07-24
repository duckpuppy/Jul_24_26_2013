package com.aci;

public interface AccountDao {
	void deposit(int accountNumber, int amount);
	void withdraw(int accountNumber, int amount);
	int getBalance(int accountNumber);
}