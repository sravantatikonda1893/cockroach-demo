package com.demo.cockroach.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demo.cockroach.entity.Transaction;

public class TransactionRowMapper implements RowMapper<Transaction> {

	@Override
	public Transaction mapRow(ResultSet rs, int arg1) throws SQLException {
		Transaction transaction = new Transaction();
		transaction.setTransactionId(rs.getString("transactionId"));
		transaction.setAccountNbr(rs.getString("accountNbr"));
		transaction.setTxnSrc(rs.getString("txnSrc"));
		transaction.setTxnType(rs.getString("txnType"));
 
        return transaction;
	}


}
