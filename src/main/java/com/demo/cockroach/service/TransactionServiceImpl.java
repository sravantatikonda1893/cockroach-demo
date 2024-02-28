package com.demo.cockroach.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.demo.cockroach.dao.TransactionDao;
import com.demo.cockroach.entity.Transaction;
@Service
public class TransactionServiceImpl implements TransactionService {
	@Resource
	TransactionDao transactionDao;
	@Override
	public List<Transaction> findAll() {
		return transactionDao.findAll();
	}
	@Override
	public void insertTransaction(Transaction transaction) {
		transactionDao.insertTransaction(transaction);
		
	}
	@Override
	public void updateTransaction(Transaction transaction) {
		transactionDao.updateTransaction(transaction);
		
	}
	@Override
	public void executeUpdateTransaction(Transaction transaction) {
		transactionDao.executeUpdateTransaction(transaction);
		
	}

	@Override
	public void deleteTransaction(Transaction transaction) {
		transactionDao.deleteTransaction(transaction);
		
	}
}
