package com.cg.obs.entities;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class Users {

	
	@Column(name="account_no")
	public BigDecimal accountNo;
	@Id
	@Column(name="user_id")
	public String userId;
	@Column(name="password")
	public String password;
	@Column(name="transaction_password")
	public String transactionPassword;
	@Column(name="secret_question")
	public String secretQuestion;
	@Column(name="secret_answer")
	public String secretAnswer;
	public BigDecimal getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(BigDecimal accountNo) {
		this.accountNo = accountNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTransactionPassword() {
		return transactionPassword;
	}
	public void setTransactionPassword(String transactionPassword) {
		this.transactionPassword = transactionPassword;
	}
	public String getSecretQuestion() {
		return secretQuestion;
	}
	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}
	public String getSecretAnswer() {
		return secretAnswer;
	}
	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}
}