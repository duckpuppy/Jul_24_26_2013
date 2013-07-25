package com.aci.lab04;

import org.springframework.stereotype.Repository;

@Repository
public class StatementDaoImpl extends  BaseDaoSupport  implements StatementDao
{
	public void addStatement(int accountNumber,String type,int amount)
	{
		String query = "Insert into statements(account_number,amount,type) values(?,?,?)";
		getJdbcTemplate().update(query,accountNumber,amount,type);
	}
}
