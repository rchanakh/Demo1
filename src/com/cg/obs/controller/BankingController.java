package com.cg.obs.controller;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.obs.entities.AccountMaster;
import com.cg.obs.entities.Customer;
import com.cg.obs.entities.Transactions;
import com.cg.obs.entities.Users;
import com.cg.obs.exception.BankingException;
import com.cg.obs.modal.ChangeAddressForm;
import com.cg.obs.modal.ChangeMobileForm;
import com.cg.obs.modal.ChangePasswordForm;
import com.cg.obs.modal.FundTransferForm;
import com.cg.obs.modal.LoginForm;
import com.cg.obs.service.IBankingService;


@Controller
public class BankingController {

	@Autowired
	IBankingService service;

	public IBankingService getService() {
		return service;
	}

	public void setService(IBankingService service) {
		this.service = service;
	}

	@RequestMapping("/enter")
	public String enter(Model model){
		LoginForm login= new LoginForm();
		model.addAttribute("login", login);
		return "Login";
	}

	@RequestMapping("loginAction")
	public String loginAction(Model model,@RequestParam("uname") String username,
			@RequestParam("password") String password,
			@Valid @ModelAttribute("login")LoginForm login,BindingResult errors){
		if(errors.hasErrors())
			return "Login";
		else{

			Users user=new Users();
			user.setUserId(username);
			user.setPassword(password);


			try {
				Users user1=service.login(user);
				if(user1!=null)
				{

					BigDecimal accNo=user1.getAccountNo();
					model.addAttribute("accNo",accNo);
					return "HomeComing";

					/*BigDecimal accNo=user1.getAccountNo();

				AccountMaster accmast=service.getBalance(user1.getAccountNo());
				BigDecimal bal=accmast.getAccountBalance();
				model.addAttribute("balance",bal);

				Customer cust=service.getName(user1.getAccountNo());
				String name=cust.getCustName();
				model.addAttribute("name",name);
				model.addAttribute("accNo",accNo);
				return "Home";*/
				}
				else
				{
					model.addAttribute("error","UserID or Password is incorrect");
					return "LoginNotFound";
				}
			} catch (BankingException e) {
				model.addAttribute("error","UserID or Password is incorrect");
				return "LoginNotFound";
			}
		}
	}




	@RequestMapping("changeAddress")
	public String showUpdatePage(Model model,@RequestParam("acc") BigDecimal accNo)
	{
		try {

			ChangeAddressForm ca=new ChangeAddressForm();
			model.addAttribute("cust",ca);
			Customer cust=service.fetchAddress(accNo);
			String address=cust.getAddress();
			model.addAttribute("address",address);
			model.addAttribute("accNo",accNo);
			return "ChangeAddress";
		} catch (BankingException e) {
			model.addAttribute("error","Address Not Found");
			return "NotFound";
		}

	}

	@RequestMapping("changeAddressAction")
	public String updateAddresAction(Model model,@RequestParam("newAddress") String address,
			@RequestParam("address") String address2,
			@RequestParam("accNo") BigDecimal accNo,
			@Valid @ModelAttribute("cust")ChangeAddressForm ca,BindingResult errors)
	{
		if(errors.hasErrors())
		{
			model.addAttribute("address",address2);
			model.addAttribute("accNo",accNo);
			return "ChangeAddress";
		}
		else{
		Customer cust2=new Customer();
		cust2.setAddress(address);
		cust2.setAccountNo(accNo);
		try {
			Customer cust1=service.changeAddress(cust2);
			String address1=cust1.getAddress();
			BigDecimal accNo1=cust1.getAccountNo();
			model.addAttribute("accNo",accNo1);
			model.addAttribute("address",address1);
			return "UpdateAddressDone";
		} catch (BankingException e) {
			model.addAttribute("error","Address Not Found");
			return "NotFound";
		}}
	}

	@RequestMapping("ChangeAddressMobile")
	public String changeAddMob(Model model,@RequestParam("acc") BigDecimal accNo){

		model.addAttribute("acc", accNo);
		return "ChangeAddressMobile";
	}

	//try method
	@RequestMapping("Try")
	public String Try(Model model,@RequestParam("accNo") BigDecimal accNo)
	{
		try {

			AccountMaster accmast=service.getBalance(accNo);
			BigDecimal bal=accmast.getAccountBalance();
			model.addAttribute("balance",bal);

			Customer cust=service.getName(accNo);
			String name=cust.getCustName();
			model.addAttribute("name",name);
			model.addAttribute("accNo",accNo);
			return "Home";
		} catch (BankingException e) {
			model.addAttribute("error","Try Error");
			return "NotFound";
		}
	}
	//try method ends



	@RequestMapping("changeMobile")
	public String changeMobile(Model model,@RequestParam("acc") BigDecimal accNo)
	{
		ChangeMobileForm cust1=new ChangeMobileForm();
		model.addAttribute("cust", cust1);
		try {

			Customer cust=service.fetchMobile(accNo);
			String mobile=cust.getContactNo();
			model.addAttribute("mobile",mobile);
			model.addAttribute("accNo",accNo);
			return "ChangeMobile";
		} catch (BankingException e) {
			model.addAttribute("accNo",accNo);
			model.addAttribute("error","MObile Not Found");
			return "NotFound";
		}

	}

	@RequestMapping("changeMobileAction")
	public String updateMobileAction(Model model,@RequestParam("newMobile") String mobile,@RequestParam("accNo") BigDecimal accNo,
			@Valid @ModelAttribute("cust")ChangeMobileForm mobform,BindingResult errors)
	{
		try {
			if(errors.hasErrors())
			{
				Customer cust=service.fetchMobile(accNo);
				String mobile1=cust.getContactNo();
				model.addAttribute("mobile",mobile1);
				model.addAttribute("accNo",accNo);
				return "ChangeMobile";
			}

			else{
				Customer cust2=new Customer();
				cust2.setContactNo(mobile);
				cust2.setAccountNo(accNo);

				Customer cust1=service.changeMobile(cust2);
				String mobile1=cust1.getContactNo();
				BigDecimal accNo1=cust1.getAccountNo();
				model.addAttribute("accNo",accNo1);
				model.addAttribute("mobile",mobile1);
				return "UpdateMobileDone";
			}}
		catch (BankingException e) {
			model.addAttribute("accNo",accNo);
			model.addAttribute("error","MObile Not Found");
			return "NotFound";
		}
	}

	@RequestMapping("FundTransfer")
	public String FundTransfer(Model model,@RequestParam("acc") BigDecimal accNo)
	{
		FundTransferForm fund1=new FundTransferForm();
		model.addAttribute("fund", fund1);

		model.addAttribute("accNo",accNo);

		return "FundTransfer";
	}

	@RequestMapping("FundTransferAction")
	public String FundTransferAction(Model model,@RequestParam("recAccNo") String recAccNo,
			@RequestParam("accNo") String accNo,@RequestParam("transPassword") String transPassword,
			@RequestParam("amount") String amount, 
			@Valid @ModelAttribute("fund")FundTransferForm fund,BindingResult errors)
	{
		try 
		{
			if(errors.hasErrors())
			{
				model.addAttribute("accNo",accNo);				
				return "FundTransfer";
			}
			else
			{
				Users user1=new Users();
				user1.setAccountNo(new BigDecimal(Integer.parseInt(accNo)));
				user1.setTransactionPassword(transPassword);
				
				Users us1=service.checkPass(user1);
				if(us1!=null)
				{
					try {
						AccountMaster s2=service.fundTrans(
								new BigDecimal(Integer.parseInt(accNo))
						,new BigDecimal(Integer.parseInt(recAccNo)),
						new BigDecimal(Integer.parseInt(amount))	);
						if(s2!=null)
						{

							BigDecimal accNo1=s2.getAccountNo();
							BigDecimal balance=s2.getAccountBalance();
							model.addAttribute("accNo",accNo1);
							model.addAttribute("balance",balance);
							return "SuccessFundTransfer";
						}
						else
						{
							model.addAttribute("error","Insufficient Balance");
							model.addAttribute("accNo",accNo);
							return "NotFound";
						}
					} catch (BankingException e) {
						model.addAttribute("error","Receiver's Account Number Does not Exist");
						model.addAttribute("accNo",accNo);
						return "NotFound";
					}
				}
				else
				{
					model.addAttribute("error","Transaction Password is incorrect");
					return "NotFound";
				}
			} 
		}
		catch (BankingException e) 
		{
			model.addAttribute("error","Transaction Password is incorrect");
			model.addAttribute("accNo",accNo);
			return "NotFound";
		}
	}



	@RequestMapping("PasswordAction")
	public String enter(Model model,@RequestParam("accNo") BigDecimal accNo){

		try {

			Users cust1=service.fetchAccountNo(accNo);

			if(cust1!=null)
			{
				BigDecimal accountNo=cust1.getAccountNo();
				String question =cust1.getSecretQuestion();

				model.addAttribute("accNo",accNo);
				model.addAttribute("question",question);

				return "SecurityQuestion";
			}

			else
			{
				model.addAttribute("error","Account Not Found");
				return "LoginNotFound";
			}

		} catch (BankingException e) {
			model.addAttribute("error","Account Not Found");
			return "LoginNotFound";
		}
	}



	@RequestMapping("SecurityQuestionAnswer")
	public String SecurityQuestionAnswer(Model model,@RequestParam("accNo") BigDecimal accNo,@RequestParam("sucAns") String sucAns){

		try {

			Users cust1=service.checkAnswer(accNo, sucAns);

			if(cust1!=null)
			{
				BigDecimal accountNo=cust1.getAccountNo();

				model.addAttribute("accNo",accNo);


				return "UpdateForgetPassword";
			}

			else
			{
				model.addAttribute("error","Answer is Not Correct");
				return "LoginNotFound";
			}

		} catch (BankingException e) {
			model.addAttribute("error","Answer is Not Correct");
			return "LoginNotFound";
		}
	}

	@RequestMapping("changeForgetPassword")
	public String changeForgetPassword(Model model,@RequestParam("accNo") BigDecimal accNo,
			@RequestParam("newPassword") String newPassword,
			@RequestParam("confirmNewPassword") String confirmNewPassword){

		try {

			Users cust1=service.changeForgetPass(accNo, newPassword, confirmNewPassword);

			if(cust1!=null)
			{

				return "UpdateForgetPasswordDone";
			}

			else
			{
				model.addAttribute("error","Password Does not Match ");
				return "LoginNotFound";
			}

		} catch (BankingException e) {
			model.addAttribute("error","Password Does not Match ");
			return "LoginNotFound";
		}
	}

	/********************************************Change Password***********************************************************/
	@RequestMapping("changePassword")
	public String changePassword(Model model,@RequestParam("acc") BigDecimal accNo)
	{
		try {

			ChangePasswordForm user1=new ChangePasswordForm();
			model.addAttribute("user", user1);
			Users user=service.fetchPassword(accNo);
			String password=user.getPassword();
			model.addAttribute("password",password);
			model.addAttribute("accNo",accNo);
			return "ChangePassword";
		} catch (BankingException e) {
			model.addAttribute("accNo",accNo);
			model.addAttribute("error","Password Not Updated");
			return "NotFound";
		}

	}

	@RequestMapping("changePasswordAction")
	public String updatePasswordAction(Model model,@RequestParam("password") String password,
			@RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") String newPassword,
			@RequestParam("new1Password") String new1Password,
			@RequestParam("accNo") BigDecimal accNo,
			@Valid @ModelAttribute("user")ChangePasswordForm passform,BindingResult errors)
	{

		Users user1=new Users();
		try {
			if(errors.hasErrors())
			{
				Users user=service.fetchPassword(accNo);
				String password1=user.getPassword();
				model.addAttribute("password",password1);
				model.addAttribute("accNo",accNo);
				return "ChangePassword";
			}

			else{

				if((oldPassword.equals(password))&&(!password.equals(newPassword))&&(new1Password.equals(newPassword))){
					user1.setPassword(newPassword);	
					user1.setAccountNo(accNo);
					Users user2=service.changePassword(user1);
					String a=user2.getPassword();
					BigDecimal b=user2.getAccountNo();
					model.addAttribute("newPassword",a);
					model.addAttribute("accNo",b);
					return "UpdatePasswordDone";
				}
				else
				{
					model.addAttribute("accNo",accNo);
					model.addAttribute("error","Password Does Not Match");
					return "NotFound";
				}
			}}catch (BankingException e) {
				model.addAttribute("accNo",accNo);
				model.addAttribute("error","Password Not Updated");
				return "NotFound";
			}
	}

	/***********************************************Change Password Ends************************************************/
	@RequestMapping("viewMiniStat")
	public String viewMiniStat(Model model,@RequestParam("acc") BigDecimal accNo){

		
		
		try {
			model.addAttribute("accNo", accNo);
			List<Transactions> MiniStat=service.getMiniStat(accNo);
			model.addAttribute("list",MiniStat);
			return "ViewMiniStatement";
			
		} catch (BankingException e) {
			model.addAttribute("accNo",accNo);
			model.addAttribute("error","Mini Statement Error");
			return "NotFound";
		}
		
	}

}
