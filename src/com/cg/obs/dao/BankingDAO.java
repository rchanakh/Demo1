package com.cg.obs.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.obs.entities.AccountMaster;
import com.cg.obs.entities.Customer;
import com.cg.obs.entities.FundTransfer;
import com.cg.obs.entities.Transactions;
import com.cg.obs.entities.Users;
import com.cg.obs.exception.BankingException;

@Repository
public class BankingDAO implements IBankingDAO {

	@PersistenceContext
	EntityManager em;
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Users login(Users user) throws BankingException{
		
		Users us;
		
		try {
			String query="select user from Users user where user.userId=:ui and user.password=:pw";
			TypedQuery<Users> tquery=em.createQuery(query, Users.class);
			tquery.setParameter("ui", user.getUserId());
			tquery.setParameter("pw", user.getPassword());
			
			 us = tquery.getSingleResult();
		
		} catch (Exception e) {
			throw new BankingException(
					"Username or password is Invalid"
							+ e.getMessage());
		
		}
		return us;
		
	}

	@Override
	public Transactions viewMiniStatement(Transactions trans)
			throws BankingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer changeMobile(Customer cust) throws BankingException {
		Customer c1=em.find(Customer.class,cust.getAccountNo());
		c1.setContactNo(cust.getContactNo());
		em.merge(c1);
		return c1;
	}

	@Override
	public Customer changeAddress(Customer cust) throws BankingException {
		Customer c1=em.find(Customer.class,cust.getAccountNo());
		c1.setAddress(cust.getAddress());
		em.merge(c1);
		return c1;
	}


	@Override
	public Users changePassword(Users user) throws BankingException {
		BigDecimal accNo=user.getAccountNo();
		String query="select user from Users user where user.accountNo=:acc";
		TypedQuery<Users> tquery=em.createQuery(query, Users.class);
		tquery.setParameter("acc", accNo);
		
		Users bean = tquery.getSingleResult();
		String pass=user.getPassword();
		bean.setPassword(pass);
		em.merge(bean);
		return bean;	
	}

	@Override
	public AccountMaster getBalance(BigDecimal accNo) throws BankingException {

		AccountMaster bean;
		try {
			String query="select user from AccountMaster user where user.accountNo=:acc";
			TypedQuery<AccountMaster> tquery=em.createQuery(query, AccountMaster.class);
			tquery.setParameter("acc", accNo);
			
			bean = tquery.getSingleResult();
		} catch (Exception e) {
			throw new BankingException(
					"unable to retrive query details with given account no"
							+ e.getMessage());
		}
		return bean;
		
	}

	@Override
	public Customer getName(BigDecimal accNo) throws BankingException {
		Customer bean;
		try {
			String query="select user from Customer user where user.accountNo=:acc";
			TypedQuery<Customer> tquery=em.createQuery(query, Customer.class);
			tquery.setParameter("acc", accNo);
			
			bean = tquery.getSingleResult();
		} catch (Exception e) {
			throw new BankingException(
					"unable to retrive query details with given account no"
							+ e.getMessage());
		}
		return bean;
		
	}

	@Override
	public Customer fetchAddress(BigDecimal accNo) throws BankingException {
		Customer bean;
		try {
			String query="select user from Customer user where user.accountNo=:acc";
			TypedQuery<Customer> tquery=em.createQuery(query, Customer.class);
			tquery.setParameter("acc", accNo);
			
			bean = tquery.getSingleResult();
		} catch (Exception e) {
			throw new BankingException(
					"unable to retrive query details with given account no"
							+ e.getMessage());
		}
		return bean;
	}

	@Override
	public Customer fetchMobile(BigDecimal accNo) throws BankingException {
		Customer bean;
		try {
			String query="select user from Customer user where user.accountNo=:acc";
			TypedQuery<Customer> tquery=em.createQuery(query, Customer.class);
			tquery.setParameter("acc", accNo);
			
			bean = tquery.getSingleResult();
		} catch (Exception e) {
			throw new BankingException(
					"unable to retrive query details with given account no"
							+ e.getMessage());
		}
		return bean;
	}

	@Override
	public Users checkPass(Users user) throws BankingException {
	Users us;
		
		try {
			String query="select user from Users user where user.accountNo=:accNo and user.transactionPassword=:tpw";
			TypedQuery<Users> tquery=em.createQuery(query, Users.class);
			tquery.setParameter("accNo", user.getAccountNo());
			tquery.setParameter("tpw", user.getTransactionPassword());
			
			 us = tquery.getSingleResult();
			 return us;
		} catch (Exception e) {
			throw new BankingException(
					"Transaction password is Invalid"
							+ e.getMessage());
		
		}
		
		/*return us;*/
	}

	@Override
	public AccountMaster fundTrans(BigDecimal accNo, BigDecimal recAccNo,
			BigDecimal amount) throws BankingException {
		
		
		AccountMaster bean;
		AccountMaster bean1;
		try {
			AccountMaster a= new AccountMaster();
			a=null;
			String query="select user from AccountMaster user where user.accountNo=:acc";
			TypedQuery<AccountMaster> tquery=em.createQuery(query, AccountMaster.class);
			tquery.setParameter("acc", accNo);
			bean = tquery.getSingleResult();
			BigDecimal amt=bean.getAccountBalance();
			
			
			String query1="select user from AccountMaster user where user.accountNo=:acc";
			TypedQuery<AccountMaster> tquery1=em.createQuery(query1, AccountMaster.class);
			tquery1.setParameter("acc", recAccNo);
			bean1 = tquery1.getSingleResult();
			
			if(bean1!=null)
			{
			
			if(amount.compareTo(amt) < 0)
			{
				AccountMaster c1=em.find(AccountMaster.class,accNo);
				BigDecimal famt=amt.subtract(amount);
				c1.setAccountBalance(famt);
				em.merge(c1);
				
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				LocalDate localDate = LocalDate.now();
				String tdate=dtf.format(localDate);
				
				FundTransfer fundEntry=new FundTransfer();
				fundEntry.setAccountNo(accNo);
				fundEntry.setPayeeAccountNo(recAccNo);
				fundEntry.setTransferAmount(amount);
				fundEntry.setDateOfTransfer(tdate);
				em.persist(fundEntry);
				
				
				Transactions tran1= new Transactions();
				tran1.setAccountNo(accNo);
				tran1.setStatus("Successfull");
				tran1.setTransactionAmount(amount);
				tran1.setTransactionDate(tdate);
				tran1.setTransactionDesc("Fund Transfer");
				em.persist(tran1);
				
				AccountMaster c2=em.find(AccountMaster.class,recAccNo);
				BigDecimal amt1=c2.getAccountBalance();
				BigDecimal fsamt=amt1.add(amount);
				c2.setAccountBalance(fsamt);
				em.merge(c2);
				
				Transactions tran2= new Transactions();
				tran2.setAccountNo(recAccNo);
				tran2.setStatus("Successfull");
				tran2.setTransactionAmount(amount);
				tran2.setTransactionDate(tdate);
				tran2.setTransactionDesc("Fund Recieved");
				em.persist(tran2);
				return c1;
			}
			else
			{
				return a;
			}
			}
			else
			{
				return null;
			}
			
		} catch (Exception e) {
			throw new BankingException(
					"Reciever Account Number Not exist"
							+ e.getMessage());
		}
		
		}
	

		@Override
			public Users fetchAccountNo(BigDecimal accNo) throws BankingException {
				Users bean;
				try {
					String query="select user from Users user where user.accountNo=:acc";
					TypedQuery<Users> tquery=em.createQuery(query, Users.class);
					tquery.setParameter("acc", accNo);
					
					bean = tquery.getSingleResult();
				} catch (Exception e) {
					throw new BankingException(
							"unable to retrive query details with given account no"
									+ e.getMessage());
				}
				return bean; 
		}

		@Override
		public Users checkAnswer(BigDecimal accNo, String sucAns)
				throws BankingException {
			Users bean;
			try {
				String query="select user from Users user where user.accountNo=:acc and user.secretAnswer=:suc";
				TypedQuery<Users> tquery=em.createQuery(query, Users.class);
				tquery.setParameter("acc", accNo);
				tquery.setParameter("suc", sucAns);
				
				bean = tquery.getSingleResult();
				
			} catch (Exception e) {
				throw new BankingException(
						"unable to retrive query details with given account no"
								+ e.getMessage());
			}
			return bean; 
		}

		@Override
		public Users changeForgetPass(BigDecimal accNo, String newPassword,
				String confirmNewPassword) throws BankingException {
			Users bean;
			try {
				if(newPassword.equals(confirmNewPassword))
				{
				String query="select user from Users user where user.accountNo=:acc";
				TypedQuery<Users> tquery=em.createQuery(query, Users.class);
				tquery.setParameter("acc", accNo);
				bean = tquery.getSingleResult();
				
				bean.setPassword(newPassword);
				em.merge(bean);
				return bean;
				}
				else
				{
					return null;
				}
			} catch (Exception e) {
				throw new BankingException(
						"unable to retrive query details with given account no"
								+ e.getMessage());
			}
		
			
		}

		@Override
		public Users fetchPassword(BigDecimal accNo) throws BankingException {
			Users bean;
			try {
				String query="select user from Users user where user.accountNo=:acc";
				TypedQuery<Users> tquery=em.createQuery(query, Users.class);
				tquery.setParameter("acc", accNo);
				
				bean = tquery.getSingleResult();
			} catch (Exception e) {
				throw new BankingException(
						"unable to retrive query details with given account no"
								+ e.getMessage());
			}
			return bean;
		}

		@Override
		public List<Transactions> getMiniStat(BigDecimal accNo)
				throws BankingException {
			String query="select trans from Transactions trans where trans.accountNo=:acc AND rownum<=10 order by trans.transactionId desc";
			TypedQuery<Transactions> tquery=em.createQuery(query, Transactions.class);
			tquery.setParameter("acc", accNo);
			List<Transactions> list= tquery.getResultList();
			return list;
		}


}
