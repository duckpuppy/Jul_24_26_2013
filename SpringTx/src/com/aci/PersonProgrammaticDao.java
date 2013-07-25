package com.aci;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@Repository
public class PersonProgrammaticDao {
	private JdbcTemplate jdbcTemplate;
	private TransactionTemplate transactionTemplate;
	
	public void addTwoDogs(final String name1,
			final String name2)throws Exception{
		final String query = "insert into dogs(name) values(?)";
		transactionTemplate.execute(new TransactionCallback<Object>() {
			public Object doInTransaction(TransactionStatus transactionStatus) {
				try{
					jdbcTemplate.update(query,name1);
					jdbcTemplate.update(query,name2);
				}
				catch(Exception ex){
					transactionStatus.setRollbackOnly();
				}
				return null;
			}
		});

	}
	
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
}
