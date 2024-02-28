package com.demo.cockroach.entity;

public class Transaction {

	String transactionId;
	String accountNbr;
	String txnSrc;
	String txnType;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getAccountNbr() {
		return accountNbr;
	}

	public void setAccountNbr(String accountNbr) {
		this.accountNbr = accountNbr;
	}

	public String getTxnSrc() {
		return txnSrc;
	}

	public void setTxnSrc(String txnSrc) {
		this.txnSrc = txnSrc;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}
}
