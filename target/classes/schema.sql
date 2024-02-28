CREATE TABLE transaction
(
  transactionId varchar(11) NOT NULL ,
 accountNbr varchar(100) NOT NULL,
 txnSrc varchar(100) DEFAULT NULL,
 txnType varchar(100) DEFAULT NULL,
 PRIMARY KEY (transactionId)
);