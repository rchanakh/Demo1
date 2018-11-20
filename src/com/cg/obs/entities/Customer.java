
package com.cg.obs.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Customer")
public class Customer {

	@Id
	@Column(name="account_no")
	public BigDecimal accountNo;
	@Column(name="customer_name")
	public String CustName;
	@Column(name="contact_no")
	public String contactNo;
	@Column(name="address")
	public String address;
	@Column(name="pancard")
	public String pancard;
	public BigDecimal getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(BigDecimal accountNo) {
		this.accountNo = accountNo;
	}
	public String getCustName() {
		return CustName;
	}
	public void setCustName(String custName) {
		CustName = custName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPancard() {
		return pancard;
	}
	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
	public Customer(BigDecimal accountNo, String custName, String contactNo,
			String address, String pancard) {
		this.accountNo = accountNo;
		CustName = custName;
		this.contactNo = contactNo;
		this.address = address;
		this.pancard = pancard;
	}
	public Customer() {
	}
	@Override
	public String toString() {
		return "Customer [accountNo=" + accountNo + ", CustName=" + CustName
				+ ", contactNo=" + contactNo + ", address=" + address
				+ ", pancard=" + pancard + "]";
	}
	
	
} 
 
