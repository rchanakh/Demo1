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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Fund_transfer")
public class FundTransfer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@SequenceGenerator(name="seq", sequenceName="Fund_Trans_Seq", allocationSize=1)
	@Column(name="fund_transfer_id")
	public int fundTransferId;
	@Column(name="Account_no")
	public  BigDecimal accountNo;
	@Column(name="payee_account_no")
	public BigDecimal payeeAccountNo;
	@Column(name="Date_of_transfer")
	public String dateOfTransfer;
	@Column(name="transfer_amount")
	public BigDecimal transferAmount;
	

	

	public int getFundTransferId() {
		return fundTransferId;
	}

	public void setFundTransferId(int fundTransferId) {
		this.fundTransferId = fundTransferId;
	}

	public BigDecimal getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(BigDecimal accountNo) {
		this.accountNo = accountNo;
	}

	public BigDecimal getPayeeAccountNo() {
		return payeeAccountNo;
	}

	public void setPayeeAccountNo(BigDecimal payeeAccountNo) {
		this.payeeAccountNo = payeeAccountNo;
	}

	public String getDateOfTransfer() {
		return dateOfTransfer;
	}

	public void setDateOfTransfer(String tdate) {
		this.dateOfTransfer = tdate;
	}

	public BigDecimal getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(BigDecimal transferAmount) {
		this.transferAmount = transferAmount;
	}

	public FundTransfer() {
		
	}
	
	@Override
	public String toString() {
		return "FundTransfer [fundTransferId=" + fundTransferId
				+ ", accountNo=" + accountNo + ", payeeAccountNo="
				+ payeeAccountNo + ", dateOfTransfer=" + dateOfTransfer
				+ ", transferAmount=" + transferAmount + "]";
	}
	

} 
 
