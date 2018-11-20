package com.cg.obs.entities;



import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Account_master")
public class AccountMaster {

	private static final long SerialVersionUID = 1L;
	@Id
	@Column(name="account_no")
	public BigDecimal accountNo;
	@Column(name="account_type")
	public String accountType;
	@Column(name="account_balance")
	public BigDecimal accountBalance;
	@Column(name="open_date")	
	public Date openDate; 
 
		public BigDecimal getAccountNo() {
				return accountNo;
			}
			public void setAccountNo(BigDecimal accountNo) {
				this.accountNo = accountNo;
			}
			public String getAccountType() {
				return accountType;
			}
			public void setAccountType(String accountType) {
				this.accountType = accountType;
			}
			public BigDecimal getAccountBalance() {
				return accountBalance;
			}
			public void setAccountBalance(BigDecimal accountBalance) {
				this.accountBalance = accountBalance;
			}
			public Date getOpenDate() {
				return openDate;
			} 
		public void setOpenDate(Date openDate) {
				this.openDate = openDate;
			}
			public static long getSerialversionuid() {
				return SerialVersionUID;
			}
			public AccountMaster(BigDecimal accountNo, String accountType,
					BigDecimal accountBalance, Date openDate) {
				this.accountNo = accountNo;
				this.accountType = accountType;
				this.accountBalance = accountBalance;
				this.openDate = openDate;
			}
			public AccountMaster() {
			}
			@Override
			public String toString() {
				return "AccountMaster [accountNo=" + accountNo + ", accountType="
						+ accountType + ", accountBalance=" + accountBalance
						+ ", openDate=" + openDate + "]";
			}
			
			
		} 
		 
