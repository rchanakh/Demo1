package com.cg.obs.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;








import com.cg.obs.dao.IBankingDAO;
import com.cg.obs.entities.AccountMaster;
import com.cg.obs.entities.Customer;
import com.cg.obs.entities.FundTransfer;
import com.cg.obs.entities.Transactions;
import com.cg.obs.entities.Users;
import com.cg.obs.exception.BankingException;

@Service
@Transactional
public class BankingService implements IBankingService {

	@Autowired
	IBankingDAO dao;
	
	
	public IBankingDAO getDao() {
		return dao;
	}

	public void setDao(IBankingDAO dao) {
		this.dao = dao;
	}

	@Override
	public Users login(Users user) throws BankingException {
		// TODO Auto-generated method stub
		return dao.login(user);
	}

	@Override
	public Transactions viewMiniStatement(Transactions trans)
			throws BankingException {
		// TODO Auto-generated method stub
		return dao.viewMiniStatement(trans);
	}

	@Override
	public Customer changeMobile(Customer cust) throws BankingException {
		// TODO Auto-generated method stub
		return dao.changeMobile(cust);
	}

	@Override
	public Customer changeAddress(Customer cust) throws BankingException {
		// TODO Auto-generated method stub
		return dao.changeAddress(cust);
	}


	@Override
	public Users changePassword(Users user) throws BankingException {
		// TODO Auto-generated method stub
		return dao.changePassword(user);
	}

	@Override
	public AccountMaster getBalance(BigDecimal accNo) throws BankingException {
		// TODO Auto-generated method stub
		return dao.getBalance(accNo);
	}

	@Override
	public Customer getName(BigDecimal accNo) throws BankingException {
		// TODO Auto-generated method stub
		return dao.getName(accNo);
	}

	@Override
	public Customer fetchAddress(BigDecimal accNo) throws BankingException {
		// TODO Auto-generated method stub
		return dao.fetchAddress(accNo);
	}

	@Override
	public Customer fetchMobile(BigDecimal accNo) throws BankingException {
		// TODO Auto-generated method stub
		return dao.fetchMobile(accNo);
	}

	@Override
	public Users checkPass(Users user) throws BankingException {
		// TODO Auto-generated method stub
		return dao.checkPass(user);
	}

	@Override
	public AccountMaster fundTrans(BigDecimal accNo, BigDecimal recAccNo,
			BigDecimal amount) throws BankingException {
		// TODO Auto-generated method stub
		return dao.fundTrans(accNo, recAccNo, amount);
	}

	@Override
	public Users fetchAccountNo(BigDecimal accNo) throws BankingException {
		// TODO Auto-generated method stub
		return dao.fetchAccountNo(accNo);
	}

	@Override
	public Users checkAnswer(BigDecimal accNo, String sucAns)
			throws BankingException {
		// TODO Auto-generated method stub
		return dao.checkAnswer(accNo, sucAns);
	}

	@Override
	public Users changeForgetPass(BigDecimal accNo, String newPassword,
			String confirmNewPassword) throws BankingException {
		// TODO Auto-generated method stub
		return dao.changeForgetPass(accNo, newPassword, confirmNewPassword);
	}

	@Override
	public Users fetchPassword(BigDecimal accNo) throws BankingException {
		// TODO Auto-generated method stub
		return dao.fetchPassword(accNo);
	}

	@Override
	public List<Transactions> getMiniStat(BigDecimal accNo)
			throws BankingException {
		// TODO Auto-generated method stub
		return dao.getMiniStat(accNo);
	}

	
}
