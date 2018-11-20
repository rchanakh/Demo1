package com.cg.obs.service;

import java.math.BigDecimal;
import java.util.List;

import com.cg.obs.entities.AccountMaster;
import com.cg.obs.entities.Customer;
import com.cg.obs.entities.FundTransfer;
import com.cg.obs.entities.Transactions;
import com.cg.obs.entities.Users;
import com.cg.obs.exception.BankingException;



public interface IBankingService {

	public Users login(Users user) throws BankingException;
	public Transactions viewMiniStatement(Transactions trans) throws BankingException;
	public Customer changeMobile(Customer cust) throws BankingException;
	public Customer changeAddress(Customer cust) throws BankingException;
	public AccountMaster fundTrans(BigDecimal accNo,BigDecimal recAccNo,BigDecimal amount) throws BankingException;
	public Users changePassword(Users user) throws BankingException;
	
	public AccountMaster getBalance(BigDecimal accNo) throws BankingException;
	public Customer getName(BigDecimal accNo) throws BankingException;
	public Customer fetchAddress(BigDecimal accNo) throws BankingException;
	public Customer fetchMobile(BigDecimal accNo) throws BankingException;
	public Users checkPass(Users user) throws BankingException;
	public Users fetchAccountNo(BigDecimal accNo) throws BankingException;
	public Users checkAnswer(BigDecimal accNo,String sucAns) throws BankingException;
	public Users changeForgetPass(BigDecimal accNo,String newPassword,String confirmNewPassword) throws BankingException;

	public Users fetchPassword(BigDecimal accNo) throws BankingException;
	public List<Transactions> getMiniStat(BigDecimal accNo) throws BankingException;
}
