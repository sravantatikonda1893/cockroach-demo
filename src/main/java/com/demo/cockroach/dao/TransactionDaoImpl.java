package com.demo.cockroach.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.demo.cockroach.entity.Transaction;
import com.demo.cockroach.mapper.TransactionRowMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionDaoImpl implements TransactionDao {
	
	public TransactionDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;  
}  
	NamedParameterJdbcTemplate template;  

	@Override
	public List<Transaction> findAll() {
		return template.query("select * from transaction", new TransactionRowMapper());
	}
	@Override
	public void insertTransaction(Transaction transaction) {
		 final String sql = "insert into transaction(transactionId, accountNbr , txnSrc,txnType) values(:transactionId,:accountNbr,:txnSrc,:txnType)";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("transactionId", transaction.getTransactionId())
					.addValue("accountNbr", transaction.getAccountNbr())
					.addValue("txnSrc", transaction.getTxnSrc())
					.addValue("txnType", transaction.getTxnType());
	        template.update(sql,param, holder);
	 
	}
	
	@Override
	public void updateTransaction(Transaction transaction) {
		 final String sql = "update transaction set txnType=:txnType, accountNbr=:accountNbr, txnSrc=:txnSrc where transactionId=:transactionId";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("transactionId", transaction.getTransactionId())
					.addValue("accountNbr", transaction.getAccountNbr())
					.addValue("txnSrc", transaction.getTxnSrc())
					.addValue("txnType", transaction.getTxnType());
	        template.update(sql,param, holder);
	 
	}
	
	@Override
	public void executeUpdateTransaction(Transaction transaction) {
		 final String sql = "update transaction set txnType=:txnType, accountNbr=:accountNbr, txnSrc=:txnSrc where transactionId=:transactionId";
			 

		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("transactionId", transaction.getTransactionId());
		 map.put("accountNbr", transaction.getAccountNbr());
		 map.put("txnSrc", transaction.getTxnSrc());
		 map.put("txnType", transaction.getTxnType());
	
		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  

	 
	}
	
	@Override
	public void deleteTransaction(Transaction transaction) {
		 final String sql = "delete from transaction where transactionId=:transactionId";
			 

		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("transactionId", transaction.getTransactionId());
	
		 template.execute(sql,map,new PreparedStatementCallback<Object>() {
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  

	 
	}
	
}
