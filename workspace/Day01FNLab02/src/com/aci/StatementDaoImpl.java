package com.aci;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StatementDaoImpl extends BaseDaoSupport implements StatementDao {

	@Override
	@Transactional(propagation=Propagation.MANDATORY)
	public void addStatement(int accountNumber, String type, int amount) {
		String query = "insert into statements(account_number,type,amount) values(?,?,?)";
		getJdbcTemplate().update(query, accountNumber, type, amount);
	}
}
