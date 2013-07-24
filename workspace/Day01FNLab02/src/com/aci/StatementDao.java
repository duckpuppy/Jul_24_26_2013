package com.aci;

public interface StatementDao {
	void addStatement(int accountNumber, String type, int amount);
}
