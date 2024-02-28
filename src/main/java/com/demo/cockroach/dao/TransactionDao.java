package com.demo.cockroach.dao;

import java.util.List;

import com.demo.cockroach.entity.Transaction;

public interface TransactionDao {

	List<Transaction> findAll();

	void insertTransaction(Transaction transaction);

	void updateTransaction(Transaction transaction);

	void executeUpdateTransaction(Transaction transaction);

	 void deleteTransaction(Transaction transaction);
}
