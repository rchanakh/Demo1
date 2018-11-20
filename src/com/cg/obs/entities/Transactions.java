package com.cg.obs.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Transaction")
public class Transactions {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@SequenceGenerator(name="seq", sequenceName="Trans_Seq", allocationSize=1)
	@Column(name="transaction_id")
	public int transactionId;
	@Column(name="tran_description")
	public String transactionDesc;
	@Column(name="t_date")
	public String transactionDate;
	@Column(name="t_amount")
	public BigDecimal transactionAmount;
	@Column(name="account_no")
	public BigDecimal accountNo;
	@Column(name="status")
	public String status;
	
	
	
	
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getTransactionDesc() {
		return transactionDesc;
	}
	public void setTransactionDesc(String transactionDesc) {
		this.transactionDesc = transactionDesc;
	}
	
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public BigDecimal getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(BigDecimal accountNo) {
		this.accountNo = accountNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId
				+ ", transactionDesc=" + transactionDesc + ", transactionDate="
				+ transactionDate + ", transactionAmount=" + transactionAmount
				+ ", accountNo=" + accountNo + ", status=" + status + "]";
	}
	public Transactions(int transactionId, String transactionDesc,
			String transactionDate, BigDecimal transactionAmount, BigDecimal accountNo,
			String status) {
		this.transactionId = transactionId;
		this.transactionDesc = transactionDesc;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
		this.accountNo = accountNo;
		this.status = status;
	}
	public Transactions() {
		
	}
	
	
} 