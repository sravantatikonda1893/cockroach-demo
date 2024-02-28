package com.demo.cockroach.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.cockroach.entity.Transaction;
import com.demo.cockroach.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Resource
	TransactionService transactionService;
	
	@GetMapping(value = "/transactions")
	public List<Transaction> getTransactions() {
		return transactionService.findAll();
	
	}
	
	@PostMapping(value = "/createTransaction")
	public void createTransaction(@RequestBody Transaction transaction) {
		 transactionService.insertTransaction(transaction);
	
	}
	@PutMapping(value = "/updateTransaction")
	public void updateTransaction(@RequestBody Transaction transaction) {
		 transactionService.updateTransaction(transaction);
	
	}
	@PutMapping(value = "/executeUpdateTransaction")
	public void executeUpdateTransaction(@RequestBody Transaction transaction) {
		 transactionService.executeUpdateTransaction(transaction);
	
	}
	
	@DeleteMapping(value = "/deleteTransactionById")
	public void deleteTransaction(@RequestBody Transaction transaction) {
		 transactionService.deleteTransaction(transaction);
	
	}
	
	
}
